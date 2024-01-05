# I use version 22 on my desktop which is 23.10
# but CI/CD on github is 22.10
java_version=21

packages=[
    # jdks and jres (for jmap, jhat, jconsole)
    f"openjdk-{java_version}-jre-headless",
    f"openjdk-{java_version}-jdk-headless",
    # java libraries
    "libjna-java",
    # tools
    "visualvm",
    "ivy",
    "ant",
    "ant-optional",
    "ant-contrib",
    "maven",
    "groovy",
    "checkstyle",
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
    "ant-doc",
    "ivy-doc",
]
