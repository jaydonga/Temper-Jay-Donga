package com.temper.jaydonga.model

import com.google.gson.annotations.SerializedName

data class JobDataModel(
    val data : List<Data>,
    val aggregations : Aggregations,
)

data class Aggregations (
    val count : Int
)

data class Data (
    val id : String,
    val status : String,
    val starts_at : String,
    val ends_at : String,
    val duration : Int,
    val tempers_needed : Int,
    val enable_auto_accept_recent_freelancers : Boolean,
    val cancellation_policy : Int,
    val archived_at : String,
    val created_at : String,
    val earnings_per_hour : Earnings_per_hour,
    val variable_pricing : Boolean,
    val factoring_allowed : Boolean,
    val is_flexible : Boolean,
    val time_variation_message : String,
    val start_time_earlier_variation : Int,
    val start_time_later_variation : Int,
    val end_time_earlier_variation : Int,
    val end_time_later_variation : Int,
    val earliest_possible_start_time : String,
    val latest_possible_end_time : String,
    val links : Links,
    val open_positions : Int,
    val high_chance_score : Int,
    val applications_count : Int,
    val flexpools : List<Flexpools>,
    val job : Job,
    val recurring_shift_schedule : String,
    val has_substituted_openings : Boolean,
    val distance : String,
    val is_auto_accepted_when_applied : Boolean,
    val chance_of_success : Boolean,
    val average_estimated_earnings_per_hour : Average_estimated_earnings_per_hour
)

data class Earnings_per_hour (
    val currency : String,
    val amount : Double
)

data class Links (
    val get_directions : String
)

data class ImageLinks (
    val hero_image : String,
    val thumb_image : String,
)

data class Flexpools (
    val name : String,
    val id : String
)

data class Job (
    val id : String,
    val title : String,
    val extra_briefing : String,
    val dress_code : String,
    val tips : Boolean,
    val slug : String,
    val reference : String,
    val archived_at : String,
    val is_agency : Boolean,
    val links : Links,
    val skills : List<Skills>,
    val project : Project,
    val category : Category,
    val report_to : Report_to,
    val appearances : List<Appearances>,
    val report_at_address : Report_at_address
)

data class Skills (
    val name : String,
    val id : String
)

data class Project (
    val id : String,
    val name : String,
    val archived_at : String,
    val client : Client
)

data class Client (
    val id : String,
    val name : String,
    val slug : String,
    val registration_name : String,
    val registration_id : Int,
    val description : String,
    val allow_temper_trial : Boolean,
    val blocked_minutes_before_shift : String,
    val links : ImageLinks,
    val rating : Rating,
    val average_response_time : Double,
    val factoring_allowed : Boolean,
    val factoring_payment_term_in_days : Int
)

data class Rating (
    val count : Int,
    val average : Double
)

data class Category (
    val id : String,
    val internalId : Int,
    val name : String,
    val name_translation : Name_translation,
    val slug : String,
    val links : Links
)

data class Report_to (
    val name : String,
    val phone : String,
    val details : String
)

data class Average_estimated_earnings_per_hour (
    val currency : String,
    val amount : Int
)

data class Appearances (
    val name : String,
    val id : String
)

data class Report_at_address (
    val zip_code : String,
    val street : String,
    val number : Int,
    val number_with_extra : Int,
    val extra : String,
    val city : String,
    val line1 : String,
    val line2 : String,
    val links : Links,
    val country : Country,
    val geo : Geo,
    val region : String
)

data class Country (
    val iso3166_1 : String,
    val human : String
)

data class Geo (
    val lat : Double,
    val lon : Double
)

data class Name_translation (
    val en_GB : String,
    val nl_NL : String
)

val currencyMap = mapOf(
    "EUR" to "€",
    "USD" to "$",
)
