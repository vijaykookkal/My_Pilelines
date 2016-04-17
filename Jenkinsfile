// Globals
def mvnHome = "/opt/apache-maven-3.2.5"
def build_vesion
def sha1
def git_url='https://github.com/WPPg2/avatar-reg.git'
def git_credentialsId='7a9d9c98-fec1-4a3c-82ff-53295d9d5c9b'
def pom_version_tag='avreg_version'

stage 'Build'
   
node('master') {
  maven_build("test","test1")
}

stage 'Create AMI'


node('master') {
   echo "$sha1"
}


def get_version() {
  def matcher = readFile('pom.xml') =~ '<avreg.version>(.+)</avreg.version>'
  matcher ? matcher[0][1] : null
}
