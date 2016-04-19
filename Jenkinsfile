//import com.hp.wpp.cd.pipelines.mavenBuild  ;
import org.foo.Zot ;



// Globals
def mvnHome = "/opt/apache-maven-3.2.5"
def build_vesion
def sha1
def git_url='https://github.com/WPPg2/avatar-reg.git'
def git_credentialsId='7a9d9c98-fec1-4a3c-82ff-53295d9d5c9b'
def pom_version_tag='avreg_version'
def repo="sdf"


stage 'Build'
   
node('master') {
   
 def mb = new com.hp.wpp.cd.pipelines.mavenBuild()
 build_vesion = mb.checkOut("$git_credentialsId","$git_url","$pom_version_tag")
  echo "$build_vesion"
 // def z = new org.foo.Zot()
 // echo "after new"
//z.checkOutFrom("${repo}")
//echo "after call"
}

stage 'Create AMI'


node('master') {
   echo "sha1"
}


