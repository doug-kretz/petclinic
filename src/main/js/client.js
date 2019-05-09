const rest = require("rest");
const mime = require("rest/interceptor/mime");
const errorCode = require('rest/interceptor/errorCode');
const defaultRequest = require("rest/interceptor/defaultRequest");
const baseRegistry = require('rest/mime/registry');


const childRegistry = baseRegistry.child();

childRegistry.register("application/hal+json", require("rest/mime/type/application/hal"));

module.exports = rest
    .wrap(mime, {registry: childRegistry})
    .wrap(errorCode)
    .wrap(defaultRequest, {headers: {"Accept": "application/hal+json"}});


