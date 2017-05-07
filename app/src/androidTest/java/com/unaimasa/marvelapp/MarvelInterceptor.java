package com.unaimasa.marvelapp;


import java.io.IOException;
import java.net.HttpURLConnection;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MarvelInterceptor implements Interceptor {

    public static final String BASE_CHARACTER_URL = "http://gateway.marvel.com/v1/public/characters/";
    public static final String BASE_CHARACTER_COMICS_URL = "/comics";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response;

        String urlString = chain.request().url().url().toString();
        if (urlString.contains(BASE_CHARACTER_COMICS_URL)) {
            response = new Response.Builder()
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_1)
                    .code(200)
                    .body(ResponseBody.create(MediaType.parse("application/json"), CHARACTER_COMICS_200_RESPONSE))
                    .code(HttpURLConnection.HTTP_OK)
                    .build();
        } else if (urlString.contains(BASE_CHARACTER_URL)) {
            response = new Response.Builder()
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_1)
                    .code(200)
                    .body(ResponseBody.create(MediaType.parse("application/json"), CHARACTER_200_RESPONSE))
                    .code(HttpURLConnection.HTTP_OK)
                    .build();
        } else {
            response = chain.proceed(chain.request());
        }

        return response;
    }

    private static final String CHARACTER_200_RESPONSE = "{  \n"+
            "   \"code\":200,\n"+
            "   \"status\":\"Ok\",\n"+
            "   \"copyright\":\"© 2017 MARVEL\",\n"+
            "   \"attributionText\":\"Data provided by Marvel. © 2017 MARVEL\",\n"+
            "   \"attributionHTML\":\"<a href=\\\"http://marvel.com\\\">Data provided by Marvel. © 2017 MARVEL</a>\",\n"+
            "   \"etag\":\"4cc402a88b3b478b6be7ba7e34aa0fd9c305843f\",\n"+
            "   \"data\":{  \n"+
            "      \"offset\":0,\n"+
            "      \"limit\":20,\n"+
            "      \"total\":1,\n"+
            "      \"count\":1,\n"+
            "      \"results\":[  \n"+
            "         {  \n"+
            "            \"id\":1009220,\n"+
            "            \"name\":\"Captain America\",\n"+
            "            \"description\":\"Vowing to serve his country any way he could, young Steve Rogers took the super soldier serum to become America's one-man army. Fighting for the red, white and blue for over 60 years, Captain America is the living, breathing symbol of freedom and liberty.\",\n"+
            "            \"modified\":\"2016-09-06T11:37:19-0400\",\n"+
            "            \"thumbnail\":{  \n"+
            "               \"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/3/50/537ba56d31087\",\n"+
            "               \"extension\":\"jpg\"\n"+
            "            },\n"+
            "            \"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1009220\",\n"+
            "            \"comics\":{  \n"+
            "               \"available\":1726,\n"+
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1009220/comics\",\n"+
            "               \"items\":[  \n"+
            "                  {  \n"+
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/43488\",\n"+
            "                     \"name\":\"A+X (2012) #1\"\n"+
            "                  }\n"+
            "               ],\n"+
            "               \"returned\":1\n"+
            "            },\n"+
            "            \"series\":{  \n"+
            "               \"available\":456,\n"+
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1009220/series\",\n"+
            "               \"items\":[  \n"+
            "                  {  \n"+
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/series/16450\",\n"+
            "                     \"name\":\"A+X (2012 - Present)\"\n"+
            "                  }\n"+
            "               ],\n"+
            "               \"returned\":1\n"+
            "            },\n"+
            "            \"stories\":{  \n"+
            "               \"available\":2646,\n"+
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1009220/stories\",\n"+
            "               \"items\":[  \n"+
            "                  {  \n"+
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/670\",\n"+
            "                     \"name\":\"X-MEN (2004) #186\",\n"+
            "                     \"type\":\"cover\"\n"+
            "                  }\n"+
            "               ],\n"+
            "               \"returned\":1\n"+
            "            },\n"+
            "            \"events\":{  \n"+
            "               \"available\":23,\n"+
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1009220/events\",\n"+
            "               \"items\":[  \n"+
            "                  {  \n"+
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/events/116\",\n"+
            "                     \"name\":\"Acts of Vengeance!\"\n"+
            "                  }\n"+
            "               ],\n"+
            "               \"returned\":1\n"+
            "            },\n"+
            "            \"urls\":[  \n"+
            "               {  \n"+
            "                  \"type\":\"detail\",\n"+
            "                  \"url\":\"http://marvel.com/comics/characters/1009220/captain_america?utm_campaign=apiRef&utm_source=0990cd31700f807b8b54609750af08ad\"\n"+
            "               },\n"+
            "               {  \n"+
            "                  \"type\":\"wiki\",\n"+
            "                  \"url\":\"http://marvel.com/universe/Captain_America_(Steve_Rogers)?utm_campaign=apiRef&utm_source=0990cd31700f807b8b54609750af08ad\"\n"+
            "               },\n"+
            "               {  \n"+
            "                  \"type\":\"comiclink\",\n"+
            "                  \"url\":\"http://marvel.com/comics/characters/1009220/captain_america?utm_campaign=apiRef&utm_source=0990cd31700f807b8b54609750af08ad\"\n"+
            "               }\n"+
            "            ]\n"+
            "         }\n"+
            "      ]\n"+
            "   }\n"+
            "}\n"+
            "\n";

    private static final String CHARACTER_COMICS_200_RESPONSE = "{  \n" +
            "   \"code\":200,\n" +
            "   \"status\":\"Ok\",\n" +
            "   \"copyright\":\"© 2017 MARVEL\",\n" +
            "   \"attributionText\":\"Data provided by Marvel. © 2017 MARVEL\",\n" +
            "   \"attributionHTML\":\"<a href=\\\"http://marvel.com\\\">Data provided by Marvel. © 2017 MARVEL</a>\",\n" +
            "   \"etag\":\"d5fc3c3a74c978bb0dec190743b612bebc9cbdc2\",\n" +
            "   \"data\":{  \n" +
            "      \"offset\":0,\n" +
            "      \"limit\":20,\n" +
            "      \"total\":1726,\n" +
            "      \"count\":20,\n" +
            "      \"results\":[  \n" +
            "         {  \n" +
            "            \"id\":63296,\n" +
            "            \"digitalId\":0,\n" +
            "            \"title\":\"Secret Empire (2017) #1\",\n" +
            "            \"issueNumber\":1,\n" +
            "            \"variantDescription\":\"\",\n" +
            "            \"description\":\"It’s been building for months, across a bevy of titles! But now, the moment has arrived for Steve Rogers to step into the light and declare his allegiance to Hydra! How can the heroes of the Marvel Universe cope with this shattering betrayal by the most trusted figure among them? And what will this mean for the world? The map of the Marvel Universe changes in ways nobody will expect — TRUST THE SECRET EMPIRE!\",\n" +
            "            \"modified\":\"2017-04-28T16:46:09-0400\",\n" +
            "            \"isbn\":\"\",\n" +
            "            \"upc\":\"75960608662700111\",\n" +
            "            \"diamondCode\":\"MAR170901\",\n" +
            "            \"ean\":\"\",\n" +
            "            \"issn\":\"\",\n" +
            "            \"format\":\"Comic\",\n" +
            "            \"pageCount\":56,\n" +
            "            \"textObjects\":[  \n" +
            "               {  \n" +
            "                  \"type\":\"issue_solicit_text\",\n" +
            "                  \"language\":\"en-us\",\n" +
            "                  \"text\":\"It’s been building for months, across a bevy of titles! But now, the moment has arrived for Steve Rogers to step into the light and declare his allegiance to Hydra! How can the heroes of the Marvel Universe cope with this shattering betrayal by the most trusted figure among them? And what will this mean for the world? The map of the Marvel Universe changes in ways nobody will expect — TRUST THE SECRET EMPIRE!\"\n" +
            "               }\n" +
            "            ],\n" +
            "            \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/63296\",\n" +
            "            \"urls\":[  \n" +
            "               {  \n" +
            "                  \"type\":\"detail\",\n" +
            "                  \"url\":\"http://marvel.com/comics/issue/63296/secret_empire_2017_1?utm_campaign=apiRef&utm_source=0990cd31700f807b8b54609750af08ad\"\n" +
            "               },\n" +
            "               {  \n" +
            "                  \"type\":\"purchase\",\n" +
            "                  \"url\":\"http://comicstore.marvel.com/Secret-Empire-1/digital-comic/45303?utm_campaign=apiRef&utm_source=0990cd31700f807b8b54609750af08ad\"\n" +
            "               }\n" +
            "            ],\n" +
            "            \"series\":{  \n" +
            "               \"resourceURI\":\"http://gateway.marvel.com/v1/public/series/23020\",\n" +
            "               \"name\":\"Secret Empire (2017)\"\n" +
            "            },\n" +
            "            \"variants\":[  \n" +
            "\n" +
            "            ],\n" +
            "            \"collections\":[  \n" +
            "\n" +
            "            ],\n" +
            "            \"collectedIssues\":[  \n" +
            "\n" +
            "            ],\n" +
            "            \"dates\":[  \n" +
            "               {  \n" +
            "                  \"type\":\"onsaleDate\",\n" +
            "                  \"date\":\"2017-05-03T00:00:00-0400\"\n" +
            "               },\n" +
            "               {  \n" +
            "                  \"type\":\"focDate\",\n" +
            "                  \"date\":\"2017-04-10T00:00:00-0400\"\n" +
            "               }\n" +
            "            ],\n" +
            "            \"prices\":[  \n" +
            "               {  \n" +
            "                  \"type\":\"printPrice\",\n" +
            "                  \"price\":4.99\n" +
            "               }\n" +
            "            ],\n" +
            "            \"thumbnail\":{  \n" +
            "               \"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/3/20/5900ab4a19359\",\n" +
            "               \"extension\":\"jpg\"\n" +
            "            },\n" +
            "            \"images\":[  \n" +
            "               {  \n" +
            "                  \"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/3/20/5900ab4a19359\",\n" +
            "                  \"extension\":\"jpg\"\n" +
            "               }\n" +
            "            ],\n" +
            "            \"creators\":{  \n" +
            "               \"available\":7,\n" +
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/63296/creators\",\n" +
            "               \"items\":[  \n" +
            "                  {  \n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/2133\",\n" +
            "                     \"name\":\"Tom Brevoort\",\n" +
            "                     \"role\":\"editor\"\n" +
            "                  },\n" +
            "                  {  \n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/694\",\n" +
            "                     \"name\":\"Mark Brooks\",\n" +
            "                     \"role\":\"penciler (cover)\"\n" +
            "                  },\n" +
            "                  {  \n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/616\",\n" +
            "                     \"name\":\"Jay Leisten\",\n" +
            "                     \"role\":\"inker\"\n" +
            "                  },\n" +
            "                  {  \n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/8671\",\n" +
            "                     \"name\":\"Jamie McKelvie\",\n" +
            "                     \"role\":\"colorist (cover)\"\n" +
            "                  },\n" +
            "                  {  \n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/9484\",\n" +
            "                     \"name\":\"Steve McNiven\",\n" +
            "                     \"role\":\"penciler\"\n" +
            "                  },\n" +
            "                  {  \n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/11434\",\n" +
            "                     \"name\":\"Nick Spencer\",\n" +
            "                     \"role\":\"writer\"\n" +
            "                  },\n" +
            "                  {  \n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/10279\",\n" +
            "                     \"name\":\"Matthew Wilson\",\n" +
            "                     \"role\":\"colorist\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"returned\":7\n" +
            "            },\n" +
            "            \"characters\":{  \n" +
            "               \"available\":2,\n" +
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/63296/characters\",\n" +
            "               \"items\":[  \n" +
            "                  {  \n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1009220\",\n" +
            "                     \"name\":\"Captain America\"\n" +
            "                  },\n" +
            "                  {  \n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1009359\",\n" +
            "                     \"name\":\"Hydra\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"returned\":2\n" +
            "            },\n" +
            "            \"stories\":{  \n" +
            "               \"available\":2,\n" +
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/63296/stories\",\n" +
            "               \"items\":[  \n" +
            "                  {  \n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/137440\",\n" +
            "                     \"name\":\"cover from Secret Empire (2017) #1\",\n" +
            "                     \"type\":\"cover\"\n" +
            "                  },\n" +
            "                  {  \n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/137441\",\n" +
            "                     \"name\":\"story from Secret Empire (2017) #1\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"returned\":2\n" +
            "            },\n" +
            "            \"events\":{  \n" +
            "               \"available\":0,\n" +
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/63296/events\",\n" +
            "               \"items\":[  \n" +
            "\n" +
            "               ],\n" +
            "               \"returned\":0\n" +
            "            }\n" +
            "         }\n" +
            "      ]\n" +
            "   }\n" +
            "}";
}
