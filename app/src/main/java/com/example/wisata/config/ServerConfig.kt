package com.example.wisata.config

 class ServerConfig {
     companion object{
         val DOMAIN_SERVER = "http://arslyn.com/wisata/"
         val DESTINASI_PATH: String = "${DOMAIN_SERVER}web/gambar/destinasi/"
         val EVENT_PATH: String = "${DOMAIN_SERVER}web/gambar/event/"
         val BERITA_PATH: String = "${DOMAIN_SERVER}web/gambar/berita/"
         val KULINER_PATH: String = "${DOMAIN_SERVER}web/gambar/kuliner/"
         val GALLERY_PATH: String = "${DOMAIN_SERVER}web/gambar/gallery/"
         val JENIS_DESTINASI_PATH: String = "${DOMAIN_SERVER}web/gambar/icon/"
     }
}