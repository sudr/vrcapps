#!/bin/sh
BASEURI="http://localhost:8080/vrcdata"

if [ $1 ]; then
   BASEURI="http://vrcapps.jelastic.servint.net/vrcdata" 
fi

curl -d '{"name" : "Advocacy"}' -H "Content-Type: application/json" $BASEURI/category
curl -d '{"name" : "Community Center"}' -H "Content-Type: application/json" $BASEURI/category
curl -d '{"name" : "Clothing"}' -H "Content-Type: application/json" $BASEURI/category
curl -d '{"name" : "Emergency Center"}' -H "Content-Type: application/json" $BASEURI/category
curl -d '{"name" : "Financial Resources"}' -H "Content-Type: application/json" $BASEURI/category
curl -d '{"name" : "Other"}' -H "Content-Type: application/json" $BASEURI/category
curl -d '{"name" : "Transport"}' -H "Content-Type: application/json" $BASEURI/category
curl -d '{"name" : "Healthcare"}' -H "Content-Type: application/json" $BASEURI/category
curl -d '{"name" : "Housing"}' -H "Content-Type: application/json" $BASEURI/category
curl -d '{"name" : "Thrift Stores"}' -H "Content-Type: application/json" $BASEURI/category

curl -d '{"name" : "Central Iowa Center for Independent Living"}' -H "Content-Type: application/json" $BASEURI/organization
curl -d '{"name" : "Disability Rights Iowa"}' -H "Content-Type: application/json" $BASEURI/organization
curl -d '{"name" : "Iowa Legal Aid"}' -H "Content-Type: application/json" $BASEURI/organization
curl -d '{"name" : "AGAPE Pregnancy Center"}' -H "Content-Type: application/json" $BASEURI/organization
curl -d '{"name" : "Amazing Grace Ministries and Outreach"}' -H "Content-Type: application/json" $BASEURI/organization

#curl -d '{"postalCode":"12345","province":"MO","lines":["1 W 1st St."],"city":"Univille"}' -H "Content-Type: application/json" $BASEURI/address

#curl -d "$BASEURI/address/1" -H "Content-Type: text/uri-list" $BASEURI/person/1/addresses
#curl -d '{"postalCode":"54321","province":"MO","lines":["2 W 1st St."],"city":"Univille"}' -H "Content-Type: application/json" $BASEURI/address
#curl -d "$BASEURI/address/2" -H "Content-Type: text/uri-list" $BASEURI/person/2/addresses
#curl -d '{"type" : "twitter", "url": "#!/johndoe"}' -H "Content-Type: application/json" $BASEURI/profile
#curl -d "$BASEURI/profile/1" -H "Content-Type: text/uri-list" $BASEURI/person/1/profiles
#curl -d '{"type" : "facebook", "url": "/janedoe"}' -H "Content-Type: application/json" $BASEURI/profile
#curl -d '{"_links": [{"rel":"facebook", "href": "$BASEURI/profile/2"}]}' -H "Content-Type: application/json" $BASEURI/person/2/profiles
