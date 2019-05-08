const rest = require("rest");
const mime = require("rest/interceptors/mime");
const registry = require("rest/mime/registry");
const errorCode = require('rest/interceptor/errorCode');
const defaultRequest = require("rest/interceptor/defaultRequest");

let childRegistry = registry.child();
chlidRegistry.register("application/hal+json", require('rest/mime/type/application/hal'));

module.exports = rest
                    .wrap(mime, {registry: childRegistry})
                    .wrap(errorCode)
                    .wrap(defaultRequest, {headers: { "Accept" : "application/hal+json"}});


