package com.adyen.android.assignment.data.remote

val VENUES_SEARCH_RESULT = """
{
  "meta": {
    "code": 200,
    "requestId": "5ac51ef86a607143de8eg5cb"
  },
  "response": {
    "warning": {
      "text": "There aren't a lot of results near you. Try something more general, reset your filters, or expand the search area."
    },
    "suggestedRadius": 600,
    "headerLocation": "Lower East Side",
    "headerFullLocation": "Lower East Side, New York",
    "headerLocationGranularity": "neighborhood",
    "totalResults": 230,
    "suggestedBounds": {
      "ne": {
        "lat": 40.724216906965616,
        "lng": -73.9896507407283
      },
      "sw": {
        "lat": 40.72151724718017,
        "lng": -73.98693222860872
      }
    },
    "groups": [
      {
        "type": "Recommended Places",
        "name": "recommended",
        "items": [
          {
            "reasons": {
              "count": 0,
              "items": [
                {
                  "summary": "This spot is popular",
                  "type": "general",
                  "reasonName": "globalInteractionReason"
                }
              ]
            },
            "referralId": "12345",
            "venue": {
              "id": "49b6e8d2f964a52016531fe3",
              "name": "Russ & Daughters",
              "location": {
                "address": "179 E Houston St",
                "crossStreet": "btwn Allen & Orchard St",
                "lat": 40.72286707707289,
                "lng": -73.98829148466851,
                "labeledLatLngs": [
                  {
                    "label": "display",
                    "lat": 40.72286707707289,
                    "lng": -73.98829148466851
                  }
                ],
                "distance": 130,
                "postalCode": "10002",
                "cc": "US",
                "city": "New York",
                "state": "NY",
                "country": "United States",
                "formattedAddress": [
                  "179 E Houston St (btwn Allen & Orchard St)",
                  "New York, NY 10002",
                  "United States"
                ]
              },
              "categories": [
                {
                  "id": "4bf58dd8d48988d1f5941735",
                  "name": "Gourmet Shop",
                  "pluralName": "Gourmet Shops",
                  "shortName": "Gourmet",
                  "icon": {
                    "prefix": "https://ss3.4sqi.net/img/categories_v2/shops/food_gourmet_",
                    "suffix": ".png"
                  },
                  "primary": true
                }
              ],
              "popularityByGeo": 0.9999983845502491,
              "venuePage": {
                "id": "77298563"
              }
            }
          }
        ]
      }
    ]
  }
}
""".trimIndent()

val NO_SEARCH_RESULT = """
 {
   "meta": {
     "code": 400,
     "errorType": "param_error",
     "errorDetail": "Value exploree is invalid for venue id",
     "requestId": "60b799f6eadef97baa81279b"
   },
   "notifications": [
     {
       "type": "notificationTray",
       "item": {
         "unreadCount": 0
       }
     }
   ],
   "response": {
     
   }
 }
""".trimIndent()

val VENUES_Detail_RESULT = """
    {"meta":{"code":200,"requestId":"60b7ab35795c99053017500f"},"response":{"venue":{"id":"5a0e475b018cbb6a2196479e","name":"Sushi By Bou","contact":{"phone":"9178701587","formattedPhone":"(917) 870-1587"},"location":{"address":"49 W 20th St","lat":40.740883116531,"lng":-73.99352459209372,"labeledLatLngs":[{"label":"display","lat":40.740883116531,"lng":-73.99352459209372}],"postalCode":"10011","cc":"US","city":"New York","state":"NY","country":"United States","formattedAddress":["49 W 20th St","New York, NY 10011","United States"]},"canonicalUrl":"https:\/\/foursquare.com\/v\/sushi-by-bou\/5a0e475b018cbb6a2196479e","categories":[{"id":"4bf58dd8d48988d1d2941735","name":"Sushi Restaurant","pluralName":"Sushi Restaurants","shortName":"Sushi","icon":{"prefix":"https:\/\/ss3.4sqi.net\/img\/categories_v2\/food\/sushi_","suffix":".png"},"primary":true}],"verified":false,"stats":{"tipCount":13},"url":"https:\/\/www.sushibybou.com","price":{"tier":2,"message":"Moderate","currency":"${'$'}"},"likes":{"count":79,"groups":[{"type":"others","count":79,"items":[]}],"summary":"79 Likes"},"dislike":false,"ok":false,"rating":9.1,"ratingColor":"00B551","ratingSignals":89,"allowMenuUrlEdit":true,"beenHere":{"count":0,"unconfirmedCount":0,"marked":false,"lastCheckinExpiredAt":0},"specials":{"count":0,"items":[]},"photos":{"count":100,"groups":[{"type":"venue","name":"Venue photos","count":100,"items":[{"id":"5c55f41dacb00b0039b2818a","createdAt":1549136925,"source":{"name":"Swarm for iOS","url":"https:\/\/www.swarmapp.com"},"prefix":"https:\/\/fastly.4sqi.net\/img\/general\/","suffix":"\/50735008_0i3KnLyuRjdIK03t7qpv3vz0gasLpeGGwZNUgIyTEQE.jpg","width":1079,"height":1920,"visibility":"public"}]}]},"reasons":{"count":1,"items":[{"summary":"Lots of people like this place","type":"general","reasonName":"rawLikesReason"}]},"hereNow":{"count":0,"summary":"Nobody here","groups":[]},"createdAt":1510885211,"tips":{"count":13,"groups":[{"type":"others","name":"All tips","count":13,"items":[{"id":"5d46e70fa838e7000719a403","createdAt":1564927759,"text":"Fast and furious and delicious. Love omakase like this and that it\u2019s feasible to actually be a regular here.","type":"user","canonicalUrl":"https:\/\/foursquare.com\/item\/5d46e70fa838e7000719a403","lang":"en","likes":{"count":0,"groups":[]},"logView":true,"agreeCount":0,"disagreeCount":0,"todo":{"count":0},"user":{"firstName":"Rock Raines","countryCode":"US"},"authorInteractionType":"liked"}]}]},"shortUrl":"http:\/\/4sq.com\/2A5AZhh","timeZone":"America\/New_York","listed":{"count":420,"groups":[{"type":"others","name":"Lists from other people","count":420,"items":[{"id":"53fcb736498e33555c07f0cf","name":"NYC","description":"","type":"others","user":{"firstName":"Allison","lastName":"L","countryCode":"MO"},"editable":false,"public":true,"collaborative":false,"url":"\/user\/77524592\/list\/nyc","canonicalUrl":"https:\/\/foursquare.com\/user\/77524592\/list\/nyc","createdAt":1409070902,"updatedAt":1577591802,"photo":{"id":"533c3f2111d2b6b478319b0b","createdAt":1396457249,"prefix":"https:\/\/fastly.4sqi.net\/img\/general\/","suffix":"\/3343327_emdxJrisnNjE-yNwUu0n9Mi0aF-5eyFVJ6e2YemzTFI.png","width":635,"height":356,"visibility":"public"},"followers":{"count":3},"listItems":{"count":78,"items":[{"id":"v5a0e475b018cbb6a2196479e","createdAt":1557397023}]}},{"id":"544ae0fc498eb3b79c0ccc51","name":"🇺🇸 NY Sushi","description":"","type":"others","user":{"firstName":"Riccardo","lastName":"L","countryCode":"US"},"editable":false,"public":true,"collaborative":false,"url":"\/user\/5546223\/list\/-ny-sushi","canonicalUrl":"https:\/\/foursquare.com\/user\/5546223\/list\/-ny-sushi","createdAt":1414193404,"updatedAt":1574289058,"photo":{"id":"4f692624e4b0656e86a9e4fd","createdAt":1332291108,"prefix":"https:\/\/fastly.4sqi.net\/img\/general\/","suffix":"\/ZIyqmzHx_vWA-y0Kzu8XxjyK3sfz0WglUoEpfjCoGwI.jpg","width":540,"height":720,"visibility":"public"},"followers":{"count":2},"listItems":{"count":37,"items":[{"id":"v5a0e475b018cbb6a2196479e","createdAt":1549952495}]}},{"id":"4fc9add5e4b081923638ed52","name":"Favorite Asian Places","description":"Misc. Places I still need to check out in Manhattan","type":"others","user":{"firstName":"David","lastName":"Z","countryCode":"US"},"editable":false,"public":true,"collaborative":false,"url":"\/drzhang\/list\/favorite-asian-places","canonicalUrl":"https:\/\/foursquare.com\/drzhang\/list\/favorite-asian-places","createdAt":1338617301,"updatedAt":1619527066,"photo":{"id":"4dd186a2a12df8594253b482","createdAt":1305577122,"prefix":"https:\/\/fastly.4sqi.net\/img\/general\/","suffix":"\/HW1RBWL4BKVU3YU2W41WRFY5ICJWEY0SUXTM1DFOO52XFDJH.jpg","width":720,"height":540,"visibility":"public"},"followers":{"count":6},"listItems":{"count":28,"items":[{"id":"v5a0e475b018cbb6a2196479e","createdAt":1569162886}]}},{"id":"51297c20e4b0d9d0028be6f3","name":"New York City","description":"","type":"others","user":{"firstName":"Bobby","countryCode":"US"},"editable":false,"public":true,"collaborative":false,"url":"\/user\/9940438\/list\/new-york-city","canonicalUrl":"https:\/\/foursquare.com\/user\/9940438\/list\/new-york-city","createdAt":1361673248,"updatedAt":1615762196,"photo":{"id":"4eb073150cd6283498ec27ea","createdAt":1320186645,"prefix":"https:\/\/fastly.4sqi.net\/img\/general\/","suffix":"\/VH1MEMPGFOB5Q4EBVOK4ITVVASWE5UK5FX5BTN0B10MHKI00.jpg","width":492,"height":330,"visibility":"public"},"followers":{"count":3},"listItems":{"count":192,"items":[{"id":"v5a0e475b018cbb6a2196479e","createdAt":1561513825}]}}]}]},"popular":{"isOpen":false,"isLocalHoliday":false,"timeframes":[{"days":"Today","includesToday":true,"open":[{"renderedTime":"6:00 PM\u201310:00 PM"}],"segments":[]},{"days":"Thu","open":[{"renderedTime":"6:00 PM\u201310:00 PM"}],"segments":[]},{"days":"Fri","open":[{"renderedTime":"5:00 PM\u2013Midnight"}],"segments":[]},{"days":"Sat","open":[{"renderedTime":"1:00 PM\u20132:00 PM"},{"renderedTime":"5:00 PM\u201310:00 PM"}],"segments":[]},{"days":"Sun","open":[{"renderedTime":"5:00 PM\u20139:00 PM"}],"segments":[]},{"days":"Mon","open":[{"renderedTime":"6:00 PM\u201310:00 PM"}],"segments":[]},{"days":"Tue","open":[{"renderedTime":"Noon\u20131:00 PM"},{"renderedTime":"5:00 PM\u201310:00 PM"}],"segments":[]}]},"seasonalHours":[],"pageUpdates":{"count":0,"items":[]},"inbox":{"count":0,"items":[]},"parent":{"id":"562a58d2498e979da966b1b5","name":"Jue Lan Club","location":{"address":"49 W 20th St","lat":40.740499,"lng":-73.992614,"labeledLatLngs":[{"label":"display","lat":40.740499,"lng":-73.992614},{"label":"entrance","lat":40.740937,"lng":-73.993704}],"postalCode":"10011","cc":"US","city":"New York","state":"NY","country":"United States","formattedAddress":["49 W 20th St","New York, NY 10011","United States"]},"categories":[{"id":"4bf58dd8d48988d145941735","name":"Chinese Restaurant","pluralName":"Chinese Restaurants","shortName":"Chinese","icon":{"prefix":"https:\/\/ss3.4sqi.net\/img\/categories_v2\/food\/asian_","suffix":".png"},"primary":true}],"delivery":{"id":"322239","url":"https:\/\/www.seamless.com\/menu\/jue-lan-club-49-w-20th-st-new-york\/322239?affiliate=1131&utm_source=foursquare-affiliate-network&utm_medium=affiliate&utm_campaign=1131&utm_content=322239","provider":{"name":"seamless","icon":{"prefix":"https:\/\/fastly.4sqi.net\/img\/general\/cap\/","sizes":[40,50],"name":"\/delivery_provider_seamless_20180129.png"}}},"venuePage":{"id":"143800896"}},"hierarchy":[{"name":"Jue Lan Club","lang":"en","id":"562a58d2498e979da966b1b5","canonicalUrl":"https:\/\/foursquare.com\/v\/jue-lan-club\/562a58d2498e979da966b1b5"}],"attributes":{"groups":[{"type":"price","name":"Price","summary":"${'$'}${'$'}","count":1,"items":[{"displayName":"Price","displayValue":"${'$'}${'$'}","priceTier":2}]},{"type":"reservations","name":"Reservations","summary":"Reservations","count":3,"items":[{"displayName":"Reservations","displayValue":"Yes"}]},{"type":"payments","name":"Credit Cards","summary":"Credit Cards","count":7,"items":[{"displayName":"Credit Cards","displayValue":"Yes (incl. American Express & MasterCard)"}]},{"type":"outdoorSeating","name":"Outdoor Seating","count":1,"items":[{"displayName":"Outdoor Seating","displayValue":"No"}]},{"type":"music","name":"Music","summary":"Music","count":3,"items":[{"displayName":"Music","displayValue":"Yes"}]},{"type":"serves","name":"Menus","summary":"Tasting Menu","count":8,"items":[{"displayName":"Tasting Menu","displayValue":"Tasting Menu"}]},{"type":"drinks","name":"Drinks","summary":"Beer, Wine & Cocktails","count":5,"items":[{"displayName":"Beer","displayValue":"Beer"},{"displayName":"Wine","displayValue":"Wine"},{"displayName":"Cocktails","displayValue":"Cocktails"}]},{"type":"restroom","name":"Restroom","summary":"Restroom","count":1,"items":[{"displayName":"Restroom","displayValue":"Yes"}]}]},"bestPhoto":{"id":"5c55f41dacb00b0039b2818a","createdAt":1549136925,"source":{"name":"Swarm for iOS","url":"https:\/\/www.swarmapp.com"},"prefix":"https:\/\/fastly.4sqi.net\/img\/general\/","suffix":"\/50735008_0i3KnLyuRjdIK03t7qpv3vz0gasLpeGGwZNUgIyTEQE.jpg","width":1079,"height":1920,"visibility":"public"},"colors":{"highlightColor":{"photoId":"5c55f41dacb00b0039b2818a","value":-15202296},"highlightTextColor":{"photoId":"5c55f41dacb00b0039b2818a","value":-1},"algoVersion":3}}}}
""".trimIndent()
