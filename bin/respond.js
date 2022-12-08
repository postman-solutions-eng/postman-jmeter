#!/usr/bin/env node

'use strict';

const yargs = require('yargs');
const argv = require('yargs')
    .scriptName('respond')
    .alias('w','workspaceID')
    .required('w', "You must specify a Workspace UID")
    .alias('k','postmanAPIKey')
    .required('k','You must provide a Postman API key')
    .alias('u','Results URL')
    .required('u','You must provide a URL to response data')
    .alias('r','Workflow run URL')
    .required('r','You must supply a URL to the workflow run')

    .wrap(yargs.terminalWidth())
 /*   .check((argv) => {
        let errors = "";
        if (fs.existsSync(argv.p) === false) {
            errors = errors + (errors.length == 0 ? '\nERROR(s)' : "") + '\n\t - Postman file not found (' + argv.p; 
        }   
        if (fs.existsSync(path.dirname(argv.j)) === false) {
            errors = errors + (errors.length == 0 ? '\n ERROR(s)' : "") + '\n\t - Output JMX path not found (' + argv.j;    
        }
        if (fs.existsSync(argv.j) && argv.o === false)
        {
            errors = errors + (errors.length == 0 ? '\n ERROR(s)' : "") + '\n\t - Target JMX file exists, set overwrite to FALSE (' + argv.j;    
        }
        if (!(typeof argv.e === 'undefined'))
          if(fs.existsSync(path.dirname(argv.e) === false)) {      
            errors = errors + (errors.length == 0 ? '\n ERROR(s)' : "") + '\n\t - Environment file path not found (' + argv.e;    
        }
        
        if(errors.length > 0)
        {
            throw new Error(errors);
        }
        else{
            return true;
        }
      })
      */
    .epilog('Copyright 2021').argv
    
const respond = require('../lib/respond');




const options = {
    postmanAPIKey: argv.k,
    workspaceID: argv.w,
    resultsURL: argv.u,
    workflowRunURL: argv.r
};

respond.respond(options);
