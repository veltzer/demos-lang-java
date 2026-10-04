# TOFIX

Findings from a code scan on 2026-10-04.

## Medium

- `build_maven.sh:2` - runs `mvn compile` but the repo has no `pom.xml` anywhere, so the script always fails; delete it (the real build is `scripts/javac_build.py` via rsconstruct) or add a pom.
- `INSTALL.txt:7` - tells the reader to run `./scripts/ubuntu_install.py`, which does not exist; `INSTALL.txt:8` says to run `make`, but there is no root Makefile (the build is `rsconstruct build`); `INSTALL.txt:11` says `ant ivy_retrieve`, but there is no `build.xml` at the root (the target lives in `build_bootstrap.xml`, needs `ant -f build_bootstrap.xml`). Rewrite INSTALL.txt to match the current rsconstruct build.
- `build_bootstrap.xml:8` - `<ivy:retrieve>` without a `file` attribute resolves `${basedir}/ivy.xml`, but the ivy file is `ivy/ivy.xml`; the target cannot work as written. Point it at `ivy/ivy.xml` or remove the ivy bootstrap.
- `rsconstruct.toml:10` - ruff (and mypy at `rsconstruct.toml:14`) list `src` and `exercises` in `src_dirs`, but neither directory holds any `.py` file (all Python is under `scripts/`); likewise shellcheck at `rsconstruct.toml:18` lists `src` and `exercises`, which hold no `.sh` files. Trim `src_dirs` to the folders that actually contain the file type.
- `scripts/check_src.sh:5` - iterates `projects/*`, but there is no `projects/` directory; the unmatched glob stays literal, `-d projects/*/src` is false and the script always exits 1. `scripts/check_names.py:13` and `scripts/plant_classpath.py:28` target the same nonexistent `projects/` layout. Remove these scripts or adapt them to `src/main/java`.

## Low

- `jit/Makefile:12` - `java -Xrunhprof:cpu=times` uses HPROF, which was removed in JDK 9, so `make run_profile` fails on any current JDK; `jit/Makefile:17` `_JIT_ARGS="trace"` is a Classic-VM-era switch that does nothing on HotSpot. Replace with `-XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining` / JFR.
- `maven/Makefile:31` - `mvn idea:idea` and `maven/Makefile:34` `mvn eclipse:eclipse` use plugins retired by Apache Maven; `maven/Makefile:37` uses `gnome-open`, which is gone from current distros (use `xdg-open`).
- `ivy/build.xml:6` - taskdef classpath points to `../lib/ivy-2.3.0.jar`, which does not exist (no `lib/` directory; jars are gitignored). Use the system `/usr/share/java/ivy.jar` as `build_bootstrap.xml` does, or remove.
- `scripts/get_deps.py:20` - `DO_ECLIPSE=True` with a hard-coded `ECLIPSE_PATH='/home/mark/install/eclipse-jee/plugins'` (`scripts/get_deps.py:54`) raises `ValueError` on any machine without that install; `scripts/get_deps.py:81` downloads a jar over plain `http://` from a defunct repository. Remove the script (static/ jars are no longer used) or modernise it.
- `scripts/select_java_version.sh:12` - selects `java-7-sun` / `java-7-openjdk` alternatives (`:16`), which no longer exist on any supported Ubuntu; remove or update.
- `scripts/devenv_netbeans.sh:3` - hard-codes `/home/mark/install/netbeans-cpp/bin/netbeans` (a C++ NetBeans in a Java repo); use `~` / a variable or remove.
- `doc/how_to_demo_instructions.txt:1` - classpath `projects/Standard/bin:static/jna.jar` refers to the old layout; classes now build into `out/classes`.
- `support/checkstyle_config.xml.orig` - leftover backups (`support/checkstyle_config.xml.orig`, `support/checkstyle_config.xml.works.1`) alongside `support/checkstyle_config.xml` and `support/suppressions.xml`, none of which are referenced (rsconstruct uses the root `checkstyle.xml`); delete them.
- `scripts/javac_build.py:3` - docstring describes the build as reproducing "the Makefile's" command, but the Makefile no longer exists; reword to describe the command directly.
