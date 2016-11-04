##############
# parameters #
##############
# do you want to show the commands executed ?
DO_MKDBG:=0
# what is the java stamp file?
IVY_STAMP:=ivy.stamp
# compile java?
DO_JAVA:=0
# what is the compile stamp file?
COMPILE_STAMP:=compile.stamp
# do the tools?
DO_TOOLS:=1

########
# code #
########
JAVA_SOURCES:=$(shell find . -name "*.java")
MAINCLASS_CHECKSTYLE:=com.puppycrawl.tools.checkstyle.Main
ALL:=$(IVY_STAMP)
BIN_FOLDERS:=$(shell find . \( -name "bin" -or -name "build" -or -name "classes" -or -name "dist" \) -and -type d)

# silent stuff
ifeq ($(DO_MKDBG),1)
Q:=
# we are not silent in this branch
else # DO_MKDBG
Q:=@
#.SILENT:
endif # DO_MKDBG

ifeq ($(DO_TOOLS),1)
ALL_DEP+=tools.stamp
endif # DO_TOOLS

ifeq ($(DO_JAVA),1)
ALL+=$(COMPILE_STAMP)
endif # DO_JAVA

###########
# targets #
###########
.PHONY: all
all: $(ALL)
	@true

$(IVY_STAMP): $(ALL_DEP)
	$(info doing [$@])
	$(Q)ant ivy_retrieve_local > /dev/null
	$(Q)touch $@
#	$(Q)scripts/get_deps.py

$(COMPILE_STAMP): $(IVY_STAMP) $(ALL_DEP)
	$(info doing [$@])
	$(Q)ant build
	$(Q)touch $@

tools.stamp: templardefs/deps.py
	$(info doing [$@])
	$(Q)templar_cmd install_deps
	$(Q)make_helper touch-mkdir $@

.PHONY: check_extras
check_extras:
	$(info doing [$@])
	$(Q)find projects/*/src -not -name "*.java" -and -type f

.PHONY: check_filenames_with_spaces
check_filenames_with_spaces:
	$(info doing [$@])
	$(Q)find . -name "* *"

.PHONY: check_imports
check_imports:
	$(info doing [$@])
	$(Q)make_helper wrapper-ok git grep -e "import .*\.\*" -- "*.java"

.PHONY: check_serialid
check_serialid:
	$(info doing [$@])
	$(Q)make_helper wrapper-ok git grep -l serialVersionUID -- "*.java"

.PHONY: check_ws_eol
check_ws_eol:
	$(info doing [$@])
	$(Q)make_helper wrapper-ok git grep "[[:space:]]$$" -- *.java

.PHONY: check_tab_eol
check_tab_eol:
	$(info doing [$@])
	$(Q)make_helper wrapper-ok git grep -l "\s$$" -- "*.java"

.PHONY: check_dbl_ws
check_dbl_ws:
	$(info doing [$@])
	$(Q)make_helper wrapper-ok git grep "  " -- "*.java"

.PHONY: check_author
check_author:
	$(info doing [$@])
	$(Q)make_helper wrapper-ok git grep -e "@author" --and --not -e "Mark Veltzer <mark@veltzer.net>" -- "*.java"

.PHONY: check_version
check_version:
	$(info doing [$@])
	$(Q)make_helper wrapper-ok git grep -l "@version" -- "*.java"

.PHONY: check_printstacktrace
check_printstacktrace:
	$(info doing [$@])
	$(Q)make_helper wrapper-ok git grep -l "printStackTrace()" -- "*.java"

.PHONY: check_exceptionnames
check_exceptionnames:
	$(info doing [$@])
	$(Q)make_helper wrapper-ok git grep -l -e "throw new RuntimeException" --and --not -e "(e)" --and --not -e "(e1)" --and --not -e "ERR_STRING" --and --not -e "errString" -- "*.java"

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
	$(Q)git grep -l "interbit" | make_helper wrapper-ok grep -v Makefile
	$(Q)git grep -l "Interbit" | make_helper wrapper-ok grep -v Makefile
	$(Q)git grep -l "InterBit" | make_helper wrapper-ok grep -v Makefile
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
	$(info JAVA_SOURCES is $(JAVA_SOURCES))
	$(info HOME is $(HOME))
	$(info BIN_FOLDERS is $(BIN_FOLDERS))
	$(info MAINCLASS_CHECKSTYLE is $(MAINCLASS_CHECKSTYLE))

# cleaning

.PHONY: clean_soft
clean_soft:
	$(info doing [$@])
	$(Q)rm -f $(ALL)
	$(Q)rm -rf $(BIN_FOLDERS)
	
.PHONY: clean
clean:
	$(info doing [$@])
	$(Q)git clean -xdf > /dev/null

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

#########
# rules #
#########
