package com.medmapper.v33001

object RetrofitClientInstance {

        private var retrofit: Retrofit? = null
        //implement correct url
        private val BASE_URL = ""
        val retrofitInstance : Retrofit?
            get() {
                if (retrofit == null ){
                    retrofit = retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit
            }
    }
