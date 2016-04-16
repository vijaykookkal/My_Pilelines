
package com.hp.wpp.cd.pipelines

def call(credentialsId,url) {
    // you can call any valid step functions from your code, just like you can from Pipeline scripts


   git credentialsId: '7a9d9c98-fec1-4a3c-82ff-53295d9d5c9b', url: 'https://github.com/WPPg2/avatar-reg.git'

  // build_version = get_version()
//   echo "Building version ${build_version}"
 //  echo "build id is ${env.BUILD_ID}"



   //sh "git rev-parse HEAD > sha1"

//   sha1 = readFile('sha1')
   //echo "sha1 is ${sha1}"

    //echo "Hello world, ${name}"
}


