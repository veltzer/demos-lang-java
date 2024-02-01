##############
# parameters #
##############
# do you want to show the commands executed ?
DO_MKDBG:=0
# do ivy styff?
DO_IVY:=0
# compile java?
DO_COMPILE:=1
# do you want dependency on the Makefile itself ?
DO_ALLDEP:=1

########
# code #
########
JAVA_SOURCES:=$(shell find src -name "*.java")
JAVA_OUTPUT:=$(shell find out -name "*.class")
MAINCLASS_CHECKSTYLE:=com.puppycrawl.tools.checkstyle.Main
ALL:=
REMOVE_FILES:=
REMOVE_FOLDERS:=
BIN_FOLDERS:=$(shell find . \( -name "bin" -or -name "build" -or -name "classes" -or -name "dist" \) -and -type d)

# what is the java stamp file?
IVY_STAMP:=ivy.stamp
# what is the compile stamp file?
COMPILE_STAMP:=compile.stamp

# silent stuff
ifeq ($(DO_MKDBG),1)
Q:=
# we are not silent in this branch
else # DO_MKDBG
Q:=@
#.SILENT:
endif # DO_MKDBG

# dependency on the makefile itself
ifeq ($(DO_ALLDEP),1)
.EXTRA_PREREQS+=$(foreach mk, ${MAKEFILE_LIST},$(abspath ${mk}))
endif

COMPILE_DEPS=
ifeq ($(DO_IVY),1)
ALL+=$(IVY_STAMP)
COMPILE_DEPS+=$(IVY_STAMP)
endif # DO_IVY

ifeq ($(DO_COMPILE),1)
ALL+=$(COMPILE_STAMP)
REMOVE_FILES+=$(JAVA_OUTPUT)
REMOVE_FOLDERS+=out/src
endif # DO_COMPILE

###########
# targets #
###########
.PHONY: all
all: $(ALL)
	@true

$(IVY_STAMP): scripts/get_deps.py
	$(info doing [$@])
	$(Q)ant ivy_retrieve_local > /dev/null
	$(Q)touch $@
	$(Q)scripts/get_deps.py

$(COMPILE_STAMP): $(COMPILE_DEPS)
	$(info doing [$@])
	$(Q)javac -Werror -Xlint:all $(JAVA_SOURCES) -d out
	$(Q)touch $@

.PHONY: check_extras
check_extras:
	$(info doing [$@])
	$(Q)find src/*/src -not -name "*.java" -and -type f

.PHONY: check_filenames_with_spaces
check_filenames_with_spaces:
	$(info doing [$@])
	$(Q)find . -name "* *"

.PHONY: check_imports
check_imports:
	$(info doing [$@])
	$(Q)pymakehelper only_print_on_error git grep -e "import .*\.\*" -- "*.java"

.PHONY: check_serialid
check_serialid:
	$(info doing [$@])
	$(Q)pymakehelper only_print_on_error git grep -l serialVersionUID -- "*.java"

.PHONY: check_ws_eol
check_ws_eol:
	$(info doing [$@])
	$(Q)pymakehelper only_print_on_error git grep "[[:space:]]$$" -- *.java

.PHONY: check_tab_eol
check_tab_eol:
	$(info doing [$@])
	$(Q)pymakehelper only_print_on_error git grep -l "\s$$" -- "*.java"

.PHONY: check_dbl_ws
check_dbl_ws:
	$(info doing [$@])
	$(Q)pymakehelper only_print_on_error git grep "  " -- "*.java"

.PHONY: check_author
check_author:
	$(info doing [$@])
	$(Q)pymakehelper only_print_on_error git grep -e "@author" --and --not -e "Mark Veltzer <mark@veltzer.net>" -- "*.java"

.PHONY: check_version
check_version:
	$(info doing [$@])
	$(Q)pymakehelper only_print_on_error git grep -l "@version" -- "*.java"

.PHONY: check_printstacktrace
check_printstacktrace:
	$(info doing [$@])
	$(Q)pymakehelper only_print_on_error git grep -l "printStackTrace()" -- "*.java"

.PHONY: check_exceptionnames
check_exceptionnames:
	$(info doing [$@])
	$(Q)pymakehelper only_print_on_error git grep -l -e "throw new RuntimeException" --and --not -e "(e)" --and --not -e "(e1)" --and --not -e "ERR_STRING" --and --not -e "errString" -- "*.java"

.PHONY: check_src
check_src:
	$(info doing [$@])
	$(Q)scripts/check_src.sh

.PHONY: check_names
check_names:
	$(info doing [$@])
	$(Q)scripts/check_names.py

.PHONY: check_interbit
check_interbit:
	$(info doing [$@])
	$(Q)git grep -l "interbit" | pymakehelper only_print_on_error grep -v Makefile
	$(Q)git grep -l "Interbit" | pymakehelper only_print_on_error grep -v Makefile
	$(Q)git grep -l "InterBit" | pymakehelper only_print_on_error grep -v Makefile
	$(Q)find . -name "*Interbit*" -or -name "*interbit*"
	$(Q)find . -name "*.docx" -or -name "*.doc" -or -name "*.pdf"

.PHONY: check_all
check_all: check_extras check_filenames_with_spaces check_imports check_serialid check_ws_eol check_tab_eol check_dbl_ws check_author check_version check_printstacktrace check_exceptionnames check_src check_names check_interbit

.PHONY: checkstyle_ant
checkstyle_ant:
	$(info doing [$@])
	$(Q)ant checkstyle

.PHONY: checkstyle
checkstyle:
	$(info doing [$@])
	$(Q)java -cp `scripts/cp.py` $(MAINCLASS_CHECKSTYLE) -c support/checkstyle_config.xml `find . -name "*.java"`

.PHONY: format_eclipse
format_eclipse:
	$(info doing [$@])
	$(Q)~/install/eclipse-jee/eclipse -nosplash -application org.eclipse.jdt.core.JavaCodeFormatter -verbose -config support/org.eclipse.jdt.core.prefs `find . -type d -and -name src`

.PHONY: build_eclipse
build_eclipse:
	$(info doing [$@])
	$(Q)~/install/eclipse-jee/eclipse -noSplash -data ~/workspace-jee -application org.eclipse.jdt.apt.core.aptBuild

.PHONY: debug
debug:
	$(info doing [$@])
	$(info ALL is $(ALL))
	$(info JAVA_SOURCES is $(JAVA_SOURCES))
	$(info BIN_FOLDERS is $(BIN_FOLDERS))
	$(info MAINCLASS_CHECKSTYLE is $(MAINCLASS_CHECKSTYLE))

# cleaning

.PHONY: clean
clean:
	$(info doing [$@])
	$(Q)rm -f $(ALL)
	$(Q)rm -f $(REMOVE_FILES)
# $(Q)rm -rf $(REMOVE_FOLDERS)

.PHONY: clean_herd
clean_hard:
	$(info doing [$@])
	$(Q)git clean -qffxd

# code measurements

.PHONY: sloccount
sloccount:
	$(info doing [$@])
	$(info doing [$@])
	$(Q)sloccount .

.PHONY: count_files
count_files:
	$(info doing [$@])
	$(Q)echo number of Java files: `find . -name "*.java" | wc -l`

.PHONY: run
run:
	$(info doing [$@])
	$(Q)java -classpath out core.basic.HelloWorld
	$(Q)cd out; java core.basic.HelloWorld

#########
# rules #
#########
