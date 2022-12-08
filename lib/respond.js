let pmRequests = [];

function sendResults(opts) {

  //get the workspace

  var https = require('follow-redirects').https;
  var fs = require('fs');
  let body = "";
  
  
  var options = {
    'method': 'GET',
    'hostname': 'api.getpostman.com',
    'path': '/workspaces/' + opts.workspaceID,
    'headers': {
      'X-API-Key': opts.postmanAPIKey
    },
    'maxRedirects': 20
  };
  
  var req = https.request(options, function (res) {
    var chunks = [];
  
    res.on("data", function (chunk) {
      chunks.push(chunk);
    });
  
    res.on("end", function (chunk) {
      body = Buffer.concat(chunks);
      createResponseCollection(JSON.parse(body.toString()), opts);
      //console.log(body.toString());
    });
  
    res.on("error", function (error) {
      console.error(error);
    });
  });
  
  req.end();

  

};

function createResponseCollection(ws, opts) {

  let workspace = ws;
  let responseCollectionID = "";
  let responseCollection = {};
  let body = "";

  workspace.workspace.collections.forEach(coll => {
    if(coll.name == 'SCM Workflow Output')
    {
      responseCollectionID = coll.id;
    }
  });

  //Get the collection
var https = require('follow-redirects').https;
var fs = require('fs');

var options = {
  'method': 'GET',
  'hostname': 'api.getpostman.com',
  'path': '/collections/' + responseCollectionID,
  'headers': {
    'X-API-Key': opts.postmanAPIKey
  },
  'maxRedirects': 20
};

var req = https.request(options, function (res) {
  var chunks = [];

  res.on("data", function (chunk) {
    chunks.push(chunk);
  });

  res.on("end", function (chunk) {
    body = Buffer.concat(chunks);
    updateCollection(JSON.parse(body.toString()), opts);
    console.log(body.toString());
  });

  res.on("error", function (error) {
    console.error(error);
  });
});

req.end();
}

function updateCollection(responseCollection, opts)
{
  let schemaURL = responseCollection.collection.info.schema;
  let body = "";
  pmRequests = [];
  findAllRequests(responseCollection, "request");

   let newCollection = {
    "collection": {
        "info": {
            "name": "SCM Workflow Output",
            "description": "This collection makes a request to the Postman Echo service to get a list of request headers sent by an HTTP client.",
            "schema": schemaURL
        },
        "item": [
            {
                "name": "SCM Workflow " + pmRequests.length,
                "event": [
                  {
                    "listen": "test",
                    "script": {
                      "exec": [
                        "//const res = pm.response.json();",
                        "const template = `",
                        "    <style>",
                        "        .summary ul {",
                        "            list-style-type: none;",
                        "        }",
                        "        .summary div {",
                        "            display: inline-block;",
                        "            width: 33%;",
                        "        }",
                        "    </style>",
                        "    <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css\">",
                        "    <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>",
                        "    <script src=\"https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js\"></script>",
                        "    <a href=\"" + opts.workflowRunURL + "\">Workflow results in GitHub</a><br>",
                        "    <img src=\"" + opts.resultsURL + "?raw=true\" height=\"75%\" width=\"75%\">`",
                        
                        "pm.visualizer.set(template, { });"
                      ],
                      "type": "text/javascript"
                    }
                  }
                ],
                "request": {
                    "url": "https://postman-echo.com/get",
                    "protocol":"https",
                    "method": "get",
                    "header": [
                        {
                            "key": "Content-Type",
                            "value": "application/json"
                        }
                    ]
                }
            }
        ]
    }
}
   pmRequests.forEach(request => {
    newCollection.collection.item.push(request)
   })
   

   var https = require('follow-redirects').https;
var fs = require('fs');

var options = {
  'method': 'PUT',
  'hostname': 'api.getpostman.com',
  'path': '/collections/' + responseCollection.collection.info._postman_id,
  'headers': {
    'Content-Type': 'application/json',
    'X-API-Key': opts.postmanAPIKey
  },
  'maxRedirects': 20
};

var req = https.request(options, function (res) {
  var chunks = [];

  res.on("data", function (chunk) {
    chunks.push(chunk);
  });

  res.on("end", function (chunk) {
    body = Buffer.concat(chunks);
    console.log(body.toString());
  });

  res.on("error", function (error) {
    console.error(error);
  });
});


req.write(JSON.stringify(newCollection));

req.end();

}
function isObject(value) {
  return !!(value && typeof value === "object" && !Array.isArray(value));
}

//Recursively find all the 'request' items, since folders and other stuff also have the 'item' key
function findAllRequests(object = {}, keyToMatch = "") {

  if (isObject(object)) {
    const entries = Object.entries(object);

    for (let i = 0; i < entries.length; i += 1) {
      const [objectKey, objectValue] = entries[i];
      if (objectKey === keyToMatch) {
        pmRequests.push(object);
        return object;
      }
      if (Array.isArray(objectValue)) {
        for (let z = 0; z < objectValue.length; z += 1) {
          findAllRequests(objectValue[z], keyToMatch);
        }
      }
      if (isObject(objectValue)) {

        const child = findAllRequests(objectValue, keyToMatch);

        if (child !== null) {
          return child;
        }
      }

    }
  }

  return null;
};


module.exports.respond = sendResults;