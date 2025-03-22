"""
Ubuntu system level depenencies for this project
"""

# I use version 22 on my desktop which is 23.10
# but CI/CD on github is 22.10
JAVA_VERSION=21

packages=[
    # jdks and jres (for jmap, jhat, jconsole)
    f"openjdk-{JAVA_VERSION}-jre-headless",
    f"openjdk-{JAVA_VERSION}-jdk-headless",
    # java libraries
    "libjna-java",
    # tools
    "visualvm",
    "groovy",
    "checkstyle",
    # build tools
    "ivy",
    "ant",
    "ant-optional",
    "ant-contrib",
    "gradle",
    "maven",
]

packages_development_environments=[
    # development environments
    # "netbeans",
    # "eclipse-cdt",
    # "eclipse-emf",
    # "eclipse-wtp",
    # "eclipse-jdt",
    # "eclipse-egit",
    # "eclipse-mylyn",
    # "eclipse-gef",
    # "eclipse-rcp",
    # "eclipse-xsd",
]

package_docs=[
    "checkstyle-doc",
    "groovy-doc",
    "gradle-doc",
    "ant-doc",
    "ivy-doc",
]
