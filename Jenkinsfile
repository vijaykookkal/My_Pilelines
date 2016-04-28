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

stage 'Deploy Blueprint'


node('AMIBuilder') {
	new File("new").mkdir()  
	
   
   sh  "
   mkdir -p /home/ec2-user/avreg
touch /home/ec2-user/avreg/deploy_avreg_input.json

cd ${WORKSPACE}/chef-repos/aws-manager-repo/cookbooks
echo $PWD

echo "ParentPomVersion is ${ParentPomVersion}"

pom_v=`echo ${ParentPomVersion} | sed "s/ //g"`

echo "pom_v is ${pom_v}"

ver=`echo ${ParentPomVersion} | sed "s/ //g"`

echo "service_name: ${service_name}"
echo "commit_id : ${commit_id}"

cat > /home/ec2-user/avreg/deploy_avreg_input.json << _EOF_
{ "service": {
		"artifact_url" : "http://ec2-52-1-56-86.compute-1.amazonaws.com/nexus/service/local/repositories/morpheussnapshots/content/com/hp/wpp/avreg/avreg-restapp/${pom_v}/avreg-restapp-${pom_v}.war" 
	},
    "secret-file" : "/home/ec2-user/encrypted_data_bag_secret"
}
_EOF_

cookbookVersion=1.0.13


cat > /home/ec2-user/avreg/deploy_avreg.json << _EOF_
{
	"service":{
		"name": "avreg", 
		"cookbook" : {
			"name" : "avreg",
			"deployment_recipe": "default",
            "environment": "dev",
			"url" : "http://ec2-52-1-56-86.compute-1.amazonaws.com/nexus/service/local/repositories/devops-test-releases/content/com/hp/wpp/gen2/avreg/${cookbookVersion}/avreg-${cookbookVersion}.tar.gz",
            "input_json_local_path" : "/home/ec2-user/avreg/deploy_avreg_input.json"
		} ,
		"env_databag_url" : "http://ec2-52-1-56-86.compute-1.amazonaws.com/nexus/service/local/repositories/devops-test-releases/content/com/hp/wpp/gen2/avreg/${cookbookVersion}/env_databags.tar.gz"
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
_EOF_





sudo chef-client -z -j /home/ec2-user/avreg/deploy_avreg.json -r "recipe[ec2::deployService]" --log_level info

avreg_ip_addr=`cat /home/ec2-user/avreg.log.ipaddr`
echo "Avreg ip address is: $avreg_ip_addr"


echo "cookbook_version=$cookbookVersion" > /home/ec2-user/avreg/avreg.log.properties
echo "service_version=${pom_v}" >> /home/ec2-user/avreg/avreg.log.properties
echo "avreg_ip_addr=$avreg_ip_addr" >> /home/ec2-user/avreg/avreg.log.properties

avreg_instance_id=`cat /home/ec2-user/avreg.log.instid`
echo "Avreg instance id is: $avreg_instance_id"
echo "avreg_instance_id=$avreg_instance_id" >> /home/ec2-user/avreg/avreg.log.properties

sudo scp -q -o StrictHostKeyChecking=no  -i /home/ec2-user/aws-test.pem /opt/keyfiles/stage/avreg/encrypted_data_bag_secret ec2-user@${avreg_ip_addr}:/home/ec2-user/encrypted_data_bag_secret
   "
}


