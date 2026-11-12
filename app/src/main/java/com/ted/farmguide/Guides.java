package com.ted.farmguide;

final class Guides {

    static final class Guide {
        final String name;
        final String tagline;
        final String[] materials;
        final String[] steps;

        Guide(String name, String tagline, String[] materials, String[] steps) {
            this.name = name;
            this.tagline = tagline;
            this.materials = materials;
            this.steps = steps;
        }
    }

    private Guides() {}

    static final Guide[] ALL = {

        new Guide(
            "Wheat Farm",
            "Easy starter crop farm. Wheat, seeds and bread.",
            new String[]{"Hoe (any type)", "Wheat seeds", "Water bucket", "Dirt or grass blocks", "Torches"},
            new String[]{
                "Find flat ground and mark out a 9x9 square.",
                "Dig out the center block and pour a water source into the hole.",
                "Use the hoe on the dirt or grass around the water to make farmland. One water source hydrates farmland up to 4 blocks away.",
                "Right-click each farmland block with seeds to plant them.",
                "Place torches around the field. Crops need light to grow and torches stop mobs spawning.",
                "When the wheat is tall and golden, break it to harvest, then replant the seeds.",
                "Use bone meal on young wheat to grow it instantly.",
                "Craft 3 wheat in a row to make bread."
            }),

        new Guide(
            "Carrot & Potato Farm",
            "Same layout as wheat, but you plant the food itself.",
            new String[]{"Carrots or potatoes", "Hoe", "Water bucket", "Torches"},
            new String[]{
                "Get a few carrots or potatoes from villages, zombie drops or chests.",
                "Build the same 9x9 farmland and water layout as the wheat farm.",
                "Right-click farmland with a carrot or potato to plant it.",
                "Wait until the plants are fully grown, then break them. Each plant drops several items.",
                "Replant some of what you collect and eat or cook the rest.",
                "Cook potatoes in a furnace, smoker or campfire to get baked potatoes.",
                "Do not eat poisonous potatoes."
            }),

        new Guide(
            "Sugar Cane Farm",
            "Paper, books and sugar.",
            new String[]{"Sugar cane", "Water bucket", "Sand, dirt or grass blocks"},
            new String[]{
                "Place a row of sand or dirt blocks next to a water source. Sugar cane must touch water on its side.",
                "Plant sugar cane on the blocks that touch the water.",
                "Cane grows up to 3 blocks tall.",
                "Break only the top 2 blocks. The bottom block stays and regrows.",
                "Craft 3 sugar cane into paper.",
                "Craft 3 paper and 1 leather into a book."
            }),

        new Guide(
            "Pumpkin & Melon Farm",
            "Fruit grows beside the stem and the stem keeps producing.",
            new String[]{"Pumpkin or melon seeds", "Hoe", "Water bucket", "Dirt or grass blocks"},
            new String[]{
                "Make farmland with a water source, like the wheat farm.",
                "Plant seeds in a row and leave the block beside each stem empty.",
                "Wait for the stem to grow. The fruit appears on a free block next to it.",
                "Break the fruit, not the stem. The stem keeps growing more fruit.",
                "Melon blocks drop melon slices. Pumpkins can be crafted into pumpkin pie with sugar and an egg."
            }),

        new Guide(
            "Cow Farm",
            "Beef, leather and milk.",
            new String[]{"Wheat", "Fences and a gate", "Bucket", "Sword (optional)"},
            new String[]{
                "Build a fenced pen with a gate on grass.",
                "Hold wheat so the cows follow you, and lead two cows into the pen.",
                "Feed each cow wheat to breed them. Hearts appear and a baby cow spawns.",
                "Wait about 5 minutes before breeding the adults again. Babies take about 20 minutes to grow up.",
                "Always keep two adults, and harvest the extra cows for beef and leather.",
                "Cook beef in a furnace, smoker or campfire to get steak.",
                "Right-click a cow with an empty bucket to get milk."
            }),

        new Guide(
            "Chicken Farm",
            "Eggs, feathers and chicken meat.",
            new String[]{"Seeds (wheat, pumpkin, melon or beetroot)", "Fences and a gate"},
            new String[]{
                "Build a fenced pen with a gate.",
                "Hold seeds to lure two chickens into the pen.",
                "Feed each chicken seeds to breed them and get a baby chicken.",
                "Chickens lay eggs every few minutes. Pick them up from the ground.",
                "Throwing an egg has a small chance to spawn a baby chicken.",
                "Harvest extra chickens for raw chicken and feathers. Cook the chicken before eating.",
                "Use feathers to craft arrows."
            }),

        new Guide(
            "Sheep & Wool Farm",
            "Renewable wool without hurting the sheep.",
            new String[]{"Shears", "Wheat", "Fences and a gate", "Dye (optional)"},
            new String[]{
                "Build a grass pen with a fence and gate.",
                "Lead sheep in with wheat and breed them.",
                "Right-click a sheep with shears to get wool.",
                "Sheep eat grass to grow their wool back.",
                "Use dye on a sheep to change its wool color.",
                "Craft 3 wool and 3 planks into a bed."
            }),

        new Guide(
            "Bamboo Farm",
            "Fast growing. Great for scaffolding, sticks and fuel.",
            new String[]{"Bamboo", "Dirt, grass or sand blocks", "Bone meal (optional)"},
            new String[]{
                "Place dirt, grass or sand blocks with space above them.",
                "Right-click the blocks with bamboo to plant it.",
                "Use bone meal to speed up growth.",
                "Break the bamboo with a sword or any tool. Cut from the top so the base keeps growing.",
                "Craft 2 bamboo into sticks.",
                "Craft 6 bamboo and 1 string into scaffolding.",
                "Bamboo also works as furnace fuel."
            }),

        new Guide(
            "Kelp Farm",
            "Underwater farm for dried kelp, a long-lasting fuel.",
            new String[]{"Kelp", "Water", "Solid blocks (dirt, sand or stone)", "Furnace"},
            new String[]{
                "Find or make a deep pool of still water.",
                "Plant kelp on the bottom, or on solid blocks placed underwater.",
                "Kelp grows upward over time.",
                "Break the top part and leave the bottom so it keeps growing.",
                "Smelt kelp in a furnace to get dried kelp.",
                "Craft 9 dried kelp into a dried kelp block. It is long-lasting furnace fuel."
            }),

        new Guide(
            "Composter & Bone Meal",
            "Turn extra crops into bone meal.",
            new String[]{"Composter (7 wood slabs)", "Seeds, crops, leaves or saplings"},
            new String[]{
                "Craft a composter from 7 wood slabs and place it down.",
                "Right-click it while holding seeds, crops, leaves or saplings.",
                "Each item has a chance to raise the compost level.",
                "When the composter is full, right-click it to take the bone meal.",
                "Use bone meal on crops, saplings and bamboo to grow them faster."
            }),

        new Guide(
            "Honey & Bee Farm",
            "Honey bottles and honeycomb.",
            new String[]{"Beehive or bee nest", "Flowers", "Glass bottles", "Shears", "Campfire"},
            new String[]{
                "Find bees near flowers, or craft a beehive from 6 planks and 3 honeycomb.",
                "Plant flowers near the hive so the bees can pollinate.",
                "Place a campfire under the hive so the bees stay calm when you harvest.",
                "When the hive is full of honey, right-click it with a glass bottle to get honey.",
                "Use shears on a full hive to get honeycomb."
            })
    };
}
