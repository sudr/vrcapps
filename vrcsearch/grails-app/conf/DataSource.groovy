dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    username = "root"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = '' // one of 'create', 'create-drop', 'update', 'validate', ''
            url = 'jdbc:mysql://localhost/vrcdata'
            loggingSql = true
        }
    }
    test {
        dataSource {
            dbCreate = ''
            url = 'jdbc:mysql://localhost/vrcdata'
        }
    }
    production {
        dataSource {
            dbCreate = ''
            url = 'jdbc:mysql://mysql-vrcapps.jelastic.servint.net/vrcdata'
            loggingSql = true
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
