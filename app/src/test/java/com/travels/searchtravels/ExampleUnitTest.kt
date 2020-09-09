package com.travels.searchtravels

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.api.services.vision.v1.model.AnnotateImageResponse
import com.google.api.services.vision.v1.model.BatchAnnotateImagesResponse
import com.google.api.services.vision.v1.model.LatLng
import com.travels.searchtravels.api.OnVisionApiListener
import com.travels.searchtravels.api.VisionApi
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    private val response = "{\n" +
            "  \"responses\": [\n" +
            "    {\n" +
            "      \"webDetection\": {\n" +
            "        \"webEntities\": [\n" +
            "          {\n" +
            "            \"entityId\": \"/t/262lrzncjs_mf\",\n" +
            "            \"score\": 0.7164\n" +
            "          },\n" +
            "          {\n" +
            "            \"entityId\": \"/m/09d_r\",\n" +
            "            \"score\": 0.7094,\n" +
            "            \"description\": \"Mountain\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"entityId\": \"/m/0knck\",\n" +
            "            \"score\": 0.57615,\n" +
            "            \"description\": \"Belukha Mountain\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"entityId\": \"/t/2ftdhlsjg83y6\",\n" +
            "            \"score\": 0.5027\n" +
            "          },\n" +
            "          {\n" +
            "            \"entityId\": \"/t/2h3dthjl3jhgx\",\n" +
            "            \"score\": 0.4766\n" +
            "          },\n" +
            "          {\n" +
            "            \"entityId\": \"/m/0fp2b\",\n" +
            "            \"score\": 0.470745,\n" +
            "            \"description\": \"Yenisei River\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"entityId\": \"/m/0drv1h\",\n" +
            "            \"score\": 0.4347701,\n" +
            "            \"description\": \"Mount Scenery\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"entityId\": \"/m/035qy\",\n" +
            "            \"score\": 0.40829998,\n" +
            "            \"description\": \"Greece\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"entityId\": \"/t/24g_mx2cljmh_\",\n" +
            "            \"score\": 0.3843\n" +
            "          },\n" +
            "          {\n" +
            "            \"entityId\": \"/m/03cjrt\",\n" +
            "            \"score\": 0.3048141,\n" +
            "            \"description\": \"Highland\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"fullMatchingImages\": [\n" +
            "          {\n" +
            "            \"url\": \"https://content.skyscnr.com/m/5462d448281ea355/original/GettyImages-468945589.jpg?resize=1800px:1800px&quality=100\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://media.holidayme.com/wp-content/uploads/2015/01/siberia-russia.jpg\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"partialMatchingImages\": [\n" +
            "          {\n" +
            "            \"url\": \"https://guidesearcher.com/uploaded/offers/2/6/2628a75032c6eca5c41973b7f4ff8ea6-1920.jpg\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://as2.ftcdn.net/jpg/01/12/73/75/500_F_112737520_m9ZssfdaFA4pLEOhNImAD5dXKUdbbG4D.jpg\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://avatars.mds.yandex.net/get-vthumb/2408238/65baf265b85d043b5ef34cc6d9b285f1/564x318_1\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://static.make.ua/catalog/16/nature-894__1557494971__250.jpg\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://guidesearcher.com/uploaded/offers/2/6/2628a75032c6eca5c41973b7f4ff8ea6-829x412.jpg\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"pagesWithMatchingImages\": [\n" +
            "          {\n" +
            "            \"url\": \"https://holidayme.com/explore/10-locations-backpacking-friend-right-now/\",\n" +
            "            \"pageTitle\": \"10 Exotic Locations To Go Backpacking With Your Best Friend Right ...\",\n" +
            "            \"fullMatchingImages\": [\n" +
            "              {\n" +
            "                \"url\": \"https://media.holidayme.com/wp-content/uploads/2015/01/siberia-russia.jpg\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://en.guidesearcher.com/offers/eu/ru/barnaul/hiking-offers/1415/\",\n" +
            "            \"pageTitle\": \"Altai - a campaign to the foot of Belukha July 15-26, 2017 ...\",\n" +
            "            \"partialMatchingImages\": [\n" +
            "              {\n" +
            "                \"url\": \"https://en.guidesearcher.com/uploaded/offers/2/6/2628a75032c6eca5c41973b7f4ff8ea6-829x412.jpg\"\n" +
            "              },\n" +
            "              {\n" +
            "                \"url\": \"https://en.guidesearcher.com/uploaded/offers/2/6/2628a75032c6eca5c41973b7f4ff8ea6-1920.jpg\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://www.skyscanner.ru/news/samye-krasivye-gory-rossii\",\n" +
            "            \"pageTitle\": \"Самые красивые <b>горы России</b>. Куда пойти в горный поход на ...\",\n" +
            "            \"fullMatchingImages\": [\n" +
            "              {\n" +
            "                \"url\": \"https://content.skyscnr.com/m/5462d448281ea355/original/GettyImages-468945589.jpg?resize=1800px:1800px&quality=100\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://yandex.ru/video/%D0%B7%D0%B0%D0%BF%D1%80%D0%BE%D1%81/%D1%81%D0%B5%D1%80%D0%B8%D0%B0%D0%BB/%D1%81%D1%87%D0%B0%D1%81%D1%82%D0%BB%D0%B8%D0%B2%D1%8B%D0%B5-%D0%BB%D1%8E%D0%B4%D0%B8-%D0%B0%D0%BB%D1%82%D0%B0%D0%B9\",\n" +
            "            \"pageTitle\": \"счастливые люди алтай: 1 тыс. видео найдено в Яндекс.Видео\",\n" +
            "            \"partialMatchingImages\": [\n" +
            "              {\n" +
            "                \"url\": \"https://avatars.mds.yandex.net/get-vthumb/2408238/65baf265b85d043b5ef34cc6d9b285f1/564x318_1\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://guidesearcher.com/offers/eu/ru/barnaul/hiking-offers/1415/\",\n" +
            "            \"pageTitle\": \"Алтай - поход к подножию Белухи 5-15 августа — GuideSearcher ...\",\n" +
            "            \"partialMatchingImages\": [\n" +
            "              {\n" +
            "                \"url\": \"https://guidesearcher.com/uploaded/offers/2/6/2628a75032c6eca5c41973b7f4ff8ea6-829x412.jpg\"\n" +
            "              },\n" +
            "              {\n" +
            "                \"url\": \"https://guidesearcher.com/uploaded/offers/2/6/2628a75032c6eca5c41973b7f4ff8ea6-1920.jpg\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://yandex.ru/video/%D0%B7%D0%B0%D0%BF%D1%80%D0%BE%D1%81/%D1%81%D0%B5%D1%80%D0%B8%D0%B0%D0%BB/%D1%81%D1%87%D0%B0%D1%81%D1%82%D0%BB%D0%B8%D0%B2%D1%8B%D0%B5-%D0%BB%D1%8E%D0%B4%D0%B8-%D0%B0%D0%BB%D1%82%D0%B0%D0%B9/1-%D1%81%D0%B5%D1%80%D0%B8%D1%8F/\",\n" +
            "            \"pageTitle\": \"счастливые люди алтай 1 серия: 1 тыс. видео найдено в Яндекс ...\",\n" +
            "            \"partialMatchingImages\": [\n" +
            "              {\n" +
            "                \"url\": \"https://avatars.mds.yandex.net/get-vthumb/2408238/65baf265b85d043b5ef34cc6d9b285f1/564x318_1\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://www.wydrukinaszkle.pl/architektura/greece-santorini/f-185-75139719\",\n" +
            "            \"pageTitle\": \"Panel szklany Greece Santorini - Wydruki na szkle\",\n" +
            "            \"partialMatchingImages\": [\n" +
            "              {\n" +
            "                \"url\": \"https://as2.ftcdn.net/jpg/01/12/73/75/500_F_112737520_m9ZssfdaFA4pLEOhNImAD5dXKUdbbG4D.jpg\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://make.ua/fotooboi/1675/\",\n" +
            "            \"pageTitle\": \"Фотообои цветы | Фото обои цветы Цветущая ветка flowers ...\",\n" +
            "            \"partialMatchingImages\": [\n" +
            "              {\n" +
            "                \"url\": \"https://static.make.ua/catalog/16/nature-894__1557494971__250.jpg\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://www.yandex.ru/video/%D0%B7%D0%B0%D0%BF%D1%80%D0%BE%D1%81/%D1%81%D0%B5%D1%80%D0%B8%D0%B0%D0%BB/%D1%81%D1%87%D0%B0%D1%81%D1%82%D0%BB%D0%B8%D0%B2%D1%8B%D0%B5-%D0%BB%D1%8E%D0%B4%D0%B8-%D0%B0%D0%BB%D1%82%D0%B0%D0%B9/3-%D1%81%D0%B5%D1%80%D0%B8%D1%8F\",\n" +
            "            \"pageTitle\": \"счастливые люди алтай 3 серия: 1 тыс. видео найдено в Яндекс ...\",\n" +
            "            \"partialMatchingImages\": [\n" +
            "              {\n" +
            "                \"url\": \"https://avatars.mds.yandex.net/get-vthumb/2408238/65baf265b85d043b5ef34cc6d9b285f1/564x318_1\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://www.yandex.ru/video/%D0%B7%D0%B0%D0%BF%D1%80%D0%BE%D1%81/%D1%81%D0%B5%D1%80%D0%B8%D0%B0%D0%BB/%D1%81%D1%87%D0%B0%D1%81%D1%82%D0%BB%D0%B8%D0%B2%D1%8B%D0%B5-%D0%BB%D1%8E%D0%B4%D0%B8-%D0%B5%D0%BD%D0%B8%D1%81%D0%B5%D0%B9/1-%D1%81%D0%B5%D1%80%D0%B8%D1%8F\",\n" +
            "            \"pageTitle\": \"счастливые люди енисей 1 серия: 1 тыс. видео найдено в ...\",\n" +
            "            \"partialMatchingImages\": [\n" +
            "              {\n" +
            "                \"url\": \"https://avatars.mds.yandex.net/get-vthumb/2408238/65baf265b85d043b5ef34cc6d9b285f1/564x318_1\"\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"visuallySimilarImages\": [\n" +
            "          {\n" +
            "            \"url\": \"https://opt-765163.ssl.1c-bitrix-cdn.ru/upload/uf/b6f/Russia-Photos-Views-z-altai.jpg?1454314789360804\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://www.onetwotrip.com/ru/blog/wp-content/uploads/2016/10/altai-mountains-russia.jpg\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://thumbs.dreamstime.com/b/%D0%BE%D0%B7%D0%B5%D1%80%D0%BE-kucherlinskoe-%D0%B3%D0%BE%D1%80-%D1%81%D0%B2%D0%B5%D1%80%D1%85%D1%83-%D0%B0%D0%BB%D1%82%D0%B0%D0%B9-%D1%80%D0%BE%D1%81%D1%81%D0%B8%D1%8F-%D0%BA%D1%80%D0%B0%D1%81%D0%B8%D0%B2%D1%8B%D0%B9-%D0%BB%D0%B0%D0%BD%D0%B4%D1%88%D0%B0%D1%84%D1%82-%D0%B1%D0%B5%D0%B7-%D0%BB%D1%8E%D0%B4%D0%B5%D0%B9-122486258.jpg\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://thumbs.dreamstime.com/b/%D1%80%D0%BE%D1%81%D1%81%D0%B8%D1%8F-%D0%B3%D0%BE%D1%80%D1%8B-altai-%D0%BE%D0%B7%D0%B5%D1%80%D0%BE-kuyguk-%D0%B2-%D0%BE%D1%81%D0%B5%D0%BD%D0%B8-80298088.jpg\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://imgprx.livejournal.net/6e89b81bc78324894dad684aa72babaa791e1523/LNphkvrpavk6VEauIlhxtErFmh5BRQxGeGBgYzS4GEmdUspqoJ3lelFr-IT2X41dR9_d-G5nM2n4S2pR6KAl5qeNWaefqOjmZSi2qsphjwk\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://thumbs.dreamstime.com/b/%D0%BA%D1%80%D0%B0%D1%81%D0%B8%D0%B2%D1%8B%D0%B9-%D0%B0%D0%BD-%D1%88%D0%B0%D1%84%D1%82-%D0%B5%D1%82%D0%B0-%D0%B3%D0%BE%D1%80%D1%8B-%D1%80%D0%BE%D1%81%D1%81%D0%B8%D1%8F-altai-89864532.jpg\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"https://sciencepop.ru/wp-content/uploads/2017/06/shutterstock_301190240.jpg\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"url\": \"http://img.travel.ru/images2/2013/05/object217949/el0.jpg\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"bestGuessLabels\": [\n" +
            "          {\n" +
            "            \"label\": \"россия горы\",\n" +
            "            \"languageCode\": \"ru\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}"

    @Test
    fun checkSeaRequest() {
        val objResponse = getObjectFromResponse(response)
        val responses: List<AnnotateImageResponse> = ObjectMapper().convertValue(
            objResponse.responses,
            object : TypeReference<List<AnnotateImageResponse?>?>() {})

        objResponse.responses = responses

        VisionApi.parseResponse(objResponse, object : OnVisionApiListener {
            override fun onSuccess(latLng: LatLng?) {
                fail("Expected sea, found Success")
            }

            override fun onErrorPlace(category: String?) {
                assertEquals("sea", category)
            }

            override fun onError() {
                fail("Expected sea, found Error")
            }
        })
    }

    @Test
    fun checkBeachRequest() {
        val objResponse = getObjectFromResponse(response)
        val responses: List<AnnotateImageResponse> = ObjectMapper().convertValue(
            objResponse.responses,
            object : TypeReference<List<AnnotateImageResponse?>?>() {})

        objResponse.responses = responses

        VisionApi.parseResponse(objResponse, object : OnVisionApiListener {
            override fun onSuccess(latLng: LatLng?) {
                fail("Expected beach, found Success")
            }

            override fun onErrorPlace(category: String?) {
                assertEquals("beach", category)
            }

            override fun onError() {
                fail("Expected beach, found Error")
            }
        })
    }

    @Test
    fun checkMountainRequest() {
        val objResponse = getObjectFromResponse(response)
        val responses: List<AnnotateImageResponse> = ObjectMapper().convertValue(
            objResponse.responses,
            object : TypeReference<List<AnnotateImageResponse?>?>() {})

        objResponse.responses = responses

        VisionApi.parseResponse(objResponse, object : OnVisionApiListener {
            override fun onSuccess(latLng: LatLng?) {
                fail("Expected mountain, found Success")
            }

            override fun onErrorPlace(category: String?) {
                assertEquals("mountain", category)
            }

            override fun onError() {
                fail("Expected mountain, found Error")
            }
        })
    }

    @Test
    fun checkSnowRequest() {
        val objResponse = getObjectFromResponse(response)
        val responses: List<AnnotateImageResponse> = ObjectMapper().convertValue(
            objResponse.responses,
            object : TypeReference<List<AnnotateImageResponse?>?>() {})

        objResponse.responses = responses

        VisionApi.parseResponse(objResponse, object : OnVisionApiListener {
            override fun onSuccess(latLng: LatLng?) {
                fail("Expected snow, found Success")
            }

            override fun onErrorPlace(category: String?) {
                assertEquals("snow", category)
            }

            override fun onError() {
                fail("Expected snow, found Error")
            }
        })
    }

    @Test
    fun checkOceanRequest() {
        val objResponse = getObjectFromResponse(response)
        val responses: List<AnnotateImageResponse> = ObjectMapper().convertValue(
            objResponse.responses,
            object : TypeReference<List<AnnotateImageResponse?>?>() {})

        objResponse.responses = responses

        VisionApi.parseResponse(objResponse, object : OnVisionApiListener {
            override fun onSuccess(latLng: LatLng?) {
                fail("Expected ocean, found Success")
            }

            override fun onErrorPlace(category: String?) {
                assertEquals("ocean", category)
            }

            override fun onError() {
                fail("Expected ocean, found Error")
            }
        })
    }

    @Test
    fun checkCorrectRequest() {
        val objResponse = getObjectFromResponse(response)
        val responses: List<AnnotateImageResponse> = ObjectMapper().convertValue(
            objResponse.responses,
            object : TypeReference<List<AnnotateImageResponse?>?>() {})

        objResponse.responses = responses

        VisionApi.parseResponse(objResponse, object : OnVisionApiListener {
            override fun onSuccess(latLng: LatLng?) {
                assertEquals(latLng?.latitude, 1.5)
                assertEquals(latLng?.longitude, 1.5)
            }

            override fun onErrorPlace(category: String?) {
                fail("Expected correct, found $category")
            }

            override fun onError() {
                fail("Expected correct, found Error")
            }
        })
    }

    private fun getObjectFromResponse(response: String): BatchAnnotateImagesResponse =
        ObjectMapper().readValue(
            response,
            BatchAnnotateImagesResponse::class.java
        )
}
