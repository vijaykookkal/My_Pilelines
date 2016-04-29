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
def service_version="s.v"
def service_cookbook_version="1.0.13"


def cd_git_url='https://github.com/WPPg2/DevOps-Deployment.git'
def cd_git_credentialsId='7a9d9c98-fec1-4a3c-82ff-53295d9d5c9b'
def commit_id="cmtid"

def service_deploy_input_json = """
{ "service": {
		"artifact_url" : "http://ec2-52-1-56-86.compute-1.amazonaws.com/nexus/service/local/repositories/morpheussnapshots/content/com/hp/wpp/avreg/avreg-restapp/${service_version}/avreg-restapp-${service_version}.war" 
	},
    "secret-file" : "/home/ec2-user/encrypted_data_bag_secret"
}
"""

def service_cd_deploy_input_json = """
{
	"service":{
		"name": "avreg", 
		"cookbook" : {
			"name" : "avreg",
			"deployment_recipe": "default",
            "environment": "dev",
			"url" : "http://ec2-52-1-56-86.compute-1.amazonaws.com/nexus/service/local/repositories/devops-test-releases/content/com/hp/wpp/gen2/avreg/${service_cookbook_version}/avreg-${service_cookbook_version}.tar.gz",
            "input_json_local_path" : "/home/ec2-user/avreg/deploy_avreg_input.json"
		} ,
		"env_databag_url" : "http://ec2-52-1-56-86.compute-1.amazonaws.com/nexus/service/local/repositories/devops-test-releases/content/com/hp/wpp/gen2/avreg/${service_cookbook_version}/env_databags.tar.gz"
	} ,
	"aws":{
    	"region" : "us-west-2",
		"ami":{
			"id":"ami-2fe0054f"
		} ,
        "key-name": "test",
		"security-groups": "default",
		"instance": {
			"user" : "ec2-user",
			"key" : {
				"name" : "test",
				"local_path" : "/home/ec2-user/aws-test.pem"
			} ,
            "tags": [
				{"key": "Name",	"value": "FMS_AVATAR_REG_NEW"},
				{"key": "Purpose", "value": "DevOps"},
				{"key": "Team", "value": "Morpheus"},
				{"key": "Owner", "value": "somnathb@hp.com"}
			],
			"temp_dir" : "/home/ec2-user"
			
		}
	} , 
	"log" :{ 
		"name": "avreg.log",
		"temp_dir": "/home/ec2-user"
	}
}
"""



stage 'Build'
   
   node('CTF') {
   
      //def mb = new com.hp.wpp.cd.pipelines.mavenBuild()
      //service_version = mb.checkOut("$service_git_credentialsId","$service_git_url","$service_pom_version_tag")
      
      //echo "$build_version"
      //mb.mvnBuild("${mvnHome}/bin/mvn","$build_version")
      echo "Build Stage"

}

stage 'Deploy' 





node('AMIBuilder') {
    def workspace = pwd()
    echo "Workspace is ${workspace}"
    git credentialsId: "$cd_git_credentialsId", url: "$cd_git_url"
    deploy_service(workspace,service_cd_deploy_input_json,service_deploy_input_json)


}

def deploy_service(workspace,cd_deploy_input_json,deploy_input_json) {
   // new File("${workspace}/cd_deploy_input.json").write(cd_deploy_input_json)
   // new File("${workspace}/deploy_input.json").write(deploy_input_json)
    sh "cat ${workspace}/deploy_input.json"
    
}


