//import com.hp.wpp.cd.pipelines.mavenBuild  ;
import org.foo.Zot ;



// Globals
def mvnHome = "/opt/apache-maven-3.2.5"
def build_version
def sha1
def git_url='https://github.com/WPPg2/avatar-reg.git'
def git_credentialsId='7a9d9c98-fec1-4a3c-82ff-53295d9d5c9b'
def pom_version_tag='avreg.version'
def repo="sdf"
def service_name="avreg"



stage 'Build'
   
   node('CTF') {
   
      //def mb = new com.hp.wpp.cd.pipelines.mavenBuild()
      //build_version = mb.checkOut("$git_credentialsId","$git_url","$pom_version_tag")
      
      //echo "$build_version"
      //mb.mvnBuild("${mvnHome}/bin/mvn","$build_version")
      echo "Build Stage"

}

stage 'Deploy' 





node('AMIBuilder') {


   echo "ENVIRONMENT VARIABLES"
   echo "======================"
   echo "env is " + env.getClass().getName()
   def envvars = env.getEnvironment()
   envvars.each{ k, v ->
        println "${k} ${v}"
   }
}




