//import com.hp.wpp.cd.pipelines.mavenBuild  ;
import org.foo.Zot ;



// Globals
def mvnHome = "/opt/apache-maven-3.2.5"
def build_version
def sha1


def repo="sdf"

def service_git_url='https://github.com/WPPg2/avatar-reg.git'
def service_git_credentialsId='7a9d9c98-fec1-4a3c-82ff-53295d9d5c9b'
def service_pom_version_tag='avreg.version'
def service_name="avreg"
def service_version
def service_cookbook_version="1.0.13"


def cd_git_url='https://github.com/WPPg2/DevOps-Deployment.git'
def cd_git_credentialsId='7a9d9c98-fec1-4a3c-82ff-53295d9d5c9b'
def commit_id="cmtid"



stage 'Build'
   
   node('CTF') {
   
      //def mb = new com.hp.wpp.cd.pipelines.mavenBuild()
      //service_version = mb.checkOut("$git_credentialsId","$git_url","$service_pom_version_tag")
      
      //echo "$build_version"
      //mb.mvnBuild("${mvnHome}/bin/mvn","$build_version")
      echo "Build Stage"

}

stage 'Deploy' 





node('AMIBuilder') {
    def workspace = pwd()
    git credentialsId: "$credentialsId", url: "$git_url"



 echo  "${env.BUILD_NUMBER}"
}

def deploy_service(credentialsId,git_url,artifact_url) {
    def service_artifact_url="http://ec2-52-1-56-86.compute-1.amazonaws.com/nexus/service/local/repositories/morpheussnapshots/content/com/hp/wpp/avreg/avreg-restapp/${pom_v}/avreg-restapp-${pom_v}.war" 
    
    def
}


