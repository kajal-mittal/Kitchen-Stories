package com.kmdev.bakingapp.ui.models

/**
 * Created by Kajal_Mittal on 05/07/17.
 */
class RecipeDetailsModel {
    /**
     * recipe : {"publisher":"Simply Recipes","f2f_url":"http://food2fork.com/view/37088","ingredients":["6 (6-inch) corn tortillas, preferably a little old and dried out","1/4 cup grapeseed oil, peanut oil, other high smoke-point oil","1/2 cup chopped onion","2 cloves garlic, minced","1 medium Anaheim, poblano or jalapeo chile, seeded, veins removed, chopped (Depending on the hotness and flavor desired. You can also mix chiles - 1 Anaheim and a half jalapeo.)","4 cups chicken broth or homemade chicken stock","1 can (14.5 oz) diced tomatoes, undrained (recommended Muir Glen fire-roasted)","1/2 teaspoon coarse salt (kosher or sea salt)","1 1/2 cups shredded cooked chicken","1 ripe avocado","1/2 cup (2 oz) shredded Monterey Jack cheese (or mild cheddar)","Chopped fresh cilantro","1 lime, cut into wedges\n"],"source_url":"http://www.simplyrecipes.com/recipes/tortilla_soup/","recipe_id":"37088","image_url":"http://static.food2fork.com/tortillasoup300x20048e4b838.jpg","social_rank":99.99981991214204,"publisher_url":"http://simplyrecipes.com","title":"Tortilla Soup"}
     */
    var recipe: RecipeBean? = null

    class RecipeBean {
        /**
         * publisher : Simply Recipes
         * f2f_url : http://food2fork.com/view/37088
         * ingredients : ["6 (6-inch) corn tortillas, preferably a little old and dried out","1/4 cup grapeseed oil, peanut oil, other high smoke-point oil","1/2 cup chopped onion","2 cloves garlic, minced","1 medium Anaheim, poblano or jalapeo chile, seeded, veins removed, chopped (Depending on the hotness and flavor desired. You can also mix chiles - 1 Anaheim and a half jalapeo.)","4 cups chicken broth or homemade chicken stock","1 can (14.5 oz) diced tomatoes, undrained (recommended Muir Glen fire-roasted)","1/2 teaspoon coarse salt (kosher or sea salt)","1 1/2 cups shredded cooked chicken","1 ripe avocado","1/2 cup (2 oz) shredded Monterey Jack cheese (or mild cheddar)","Chopped fresh cilantro","1 lime, cut into wedges\n"]
         * source_url : http://www.simplyrecipes.com/recipes/tortilla_soup/
         * recipe_id : 37088
         * image_url : http://static.food2fork.com/tortillasoup300x20048e4b838.jpg
         * social_rank : 99.99981991214204
         * publisher_url : http://simplyrecipes.com
         * title : Tortilla Soup
         */
        var publisher: String? = null
        var f2f_url: String? = null
        var source_url: String? = null
        var recipe_id: String? = null
        var image_url: String? = null
        var social_rank: Double = 0.toDouble()
        var publisher_url: String? = null
        var title: String? = null
        var ingredients: List<String>? = null
    }
}
