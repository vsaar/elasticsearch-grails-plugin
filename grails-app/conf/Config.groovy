log4j = {
    error 'org.codehaus.groovy.grails',
            'org.springframework',
            'org.hibernate',
            'net.sf.ehcache.hibernate'
    debug 'org.grails.plugins.elasticsearch'
}

elasticSearch {
    /**
     * Date formats used by the unmarshaller of the JSON responses
     */
    date.formats = ["yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"]

    /**
     * Hosts for remote ElasticSearch instances.
     * Will only be used with the "transport" client mode.
     * If the client mode is set to "transport" and no hosts are defined, ["localhost", 9300] will be used by default.
     */
    client.hosts = [
            [host: 'localhost', port: 9300]
    ]

    disableAutoIndex = false
    index {
        compound_format = true
    }
    unmarshallComponents = true

    searchableProperty.name = 'searchable'
}

environments {
    development {
        elasticSearch {
            /**
             * Possible values : "local", "node", "transport"
             */
            client.mode = 'local'
            client.transport.sniff = true
            bulkIndexOnStartup = true
        }
    }

    test {
        elasticSearch {
            client.mode = 'local'
            client.transport.sniff = true
            index.store.type = 'memory'
            datastoreImpl = 'hibernateDatastore'
        }
    }

    production {
        elasticSearch.client.mode = 'node'
    }
}

grails.doc.authors = 'Noam Y. Tenne, Manuarii Stein, Stephane Maldini, Serge P. Nekoval'
grails.doc.license = 'Apache License 2.0'
grails.views.default.codec = 'none' // none, html, base64
grails.views.gsp.encoding = 'UTF-8'

// Uncomment and edit the following lines to start using Grails encoding & escaping improvements

/* remove this line 
// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside null
                scriptlet = 'none' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}
remove this line */

grails.databinding.dateFormats= ["yyyy-MM-dd'T'HH:mm:ss.SSSX"]
