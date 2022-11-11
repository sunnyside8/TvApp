
tvapp2.actors.insertMany([{
  "_id": "63692ff4f52e5a193d18a437",
  "name": "Emmy Rossum",
  "birthday": new Date("<1986-09-16>"),
  "picture_url": "https://media.glamour.com/photos/59ff8c15b0ba91733b05cfad/6:7/w_2831,h_3303,c_limit/emmy-rossum-burts-bees.JPG",
  "approved": true
},{
  "_id": "63692ff4f52e5a193d18a438",
  "name": "William H. Macy",
  "birthday": new Date("1950-03-13"),
  "picture_url": "https://media1.popsugar-assets.com/files/thumbor/8YINoMrRTUdqLty4C0ZvRl03f9g/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2016/04/27/945/n/1922398/34f01cd7_GettyImages-463732560/i/Emmy-Rossum.jpg",
  "approved": false
},{
  "_id":"636b678206199f11c7dc2494",
  "name": "Dwayne Johnson",
  "birthday": new Date("1972-05-02"),
  "picture_url": "https://cdn.britannica.com/60/222660-050-064DBA89/Dwayne-Johnson-AKA-The-Rock-2019.jpg",
  "approved": true
},{
  "_id" : "636b678206199f11c7dc2495",
  "name": "Aldis Hodge",
  "birthday": new Date("1986-09-20"),
  "picture_url": "https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Aldis_Hodge_2016.jpg/800px-Aldis_Hodge_2016.jpg",
  "approved": true
},{
  "_id":"636b678206199f11c7dc2496",
  "name": "Pierce Brosnan",
  "birthday": new Date("1953-05-16"),
  "picture_url": "https://www.indiewire.com/wp-content/uploads/2022/10/Pierce-Brosnan.png",
  "approved": true
}]);


db.films.insertOne({
  "_id" : ObjectId("636b69d1da07d11846e5d171"),
  "title" : "Black Adam",
  "img_url" : "https://pbs.twimg.com/media/Fbrr88FXgAADzHN?format=jpg&name=large",
  "year_of_release" : NumberInt(2022),
  "genres" : [
      "Action",
      "Adventure"
  ],
  "actors" : [
      DBRef("actors", ObjectId("636b678206199f11c7dc2494")),
      DBRef("actors", ObjectId("636b678206199f11c7dc2495")),
      DBRef("actors", ObjectId("636b678206199f11c7dc2496"))
  ],
  "rating" : NumberInt(8),
  "description" : "Nearly 5,000 years after he was bestowed with the almighty powers of the ancient gods--and imprisoned just as quickly--Black Adam (Dwayne Johnson) is freed from his earthly tomb, ready to unleash his unique form of justice on the modern world.",
  "approved" : true
}
;


db.showtimes.insertOne({
  "_id" : ObjectId("63692ff4f52e5a193d18a43a"),
  "title" : "Shameless",
  "imgUrl" : "https://m.media-amazon.com/images/I/71oDvfRzxtL._AC_SL1000_.jpg",
  "year_of_release" : NumberInt(2011),
  "genres" : [
      {
          "genre" : "Comedy"
      },
      {
          "genre" : "Drama"
      }
  ],
  "actors" : [
      DBRef("actors", ObjectId("63692ff4f52e5a193d18a437")),
      DBRef("actors", ObjectId("63692ff4f52e5a193d18a438"))
  ],
  "rating" : NumberInt(9),
  "description" : "A scrappy, feisty, fiercely loyal Chicago family makes no apologies.",
  "approved" : false
})

db.users.insertOne({
  "_id":"6368f8b7cd7f7a4b59c82bc4",
  "fullName": "Stanislava Oncheva",
  "username": "stanislavaoncheva",
  "password": "8bd8b7354036136db8c1922a54a2794d9dc326395d3c3f09ed2d4c668cbb97cb10ff1186e85f6263",
  "email": "emmawatson2@abv.bg",
  "roles": [
    "USER"
  ],
  "_class": "org.example.model.entity.UserEntity"
})

 quit();