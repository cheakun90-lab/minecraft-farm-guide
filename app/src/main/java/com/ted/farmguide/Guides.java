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
            }),

        new Guide(
            "Iron Golem Farm",
            "Advanced. Automatic iron ingots from iron golems.",
            new String[]{"3 or more villagers", "A bed for each villager", "A zombie in a cage", "Name tag", "Boats or minecarts to move villagers", "Water bucket", "Lava bucket", "Hoppers and a chest", "Lots of building blocks"},
            new String[]{
                "Build the farm up high or underground and close it in, so other mobs cannot spawn nearby.",
                "Bring the villagers in by boat or minecart and give each one its own small cell with a bed.",
                "Put a zombie in a cage where the villagers can see it. Scared villagers make iron golems spawn.",
                "Use a name tag on the zombie so it never despawns, and keep it out of sunlight so it does not burn.",
                "Build a flat spawning platform around the villagers with 3 blocks of empty space above it.",
                "Make water flow across the platform to push the golems to one spot.",
                "At that spot, add a lava blade to kill the golems. Place it so the drops land on a hopper and not in the lava, because lava destroys items.",
                "Run the hoppers into a chest. Each golem drops 3 to 5 iron ingots.",
                "Be careful around lava. Java and Bedrock designs are different, so follow a tutorial made for your version."
            }),

        new Guide(
            "Gunpowder (Creeper) Farm",
            "Advanced. Gunpowder for fireworks and TNT.",
            new String[]{"Lots of stone blocks", "Water buckets", "Hoppers and a chest", "Slabs (to stop spawns in the wrong places)", "Sword"},
            new String[]{
                "Build high in the sky or far from caves. Mobs spawn in the dark, so a farm in the open is the only dark place nearby.",
                "Light up the ground and caves near you so mobs spawn only in your farm.",
                "Build a big spawning platform with walls and a roof. Leave it dark and put no torches inside.",
                "Leave 3 blocks of height so creepers can spawn.",
                "Make water streams that push the mobs to a hole in the middle.",
                "Under the hole, add hoppers and a chest, or a long drop to a kill spot.",
                "Mobs only spawn when you are 24 to 128 blocks away, so build an AFK spot in that range.",
                "Creepers drop 0 to 2 gunpowder each. Collect it from the chest."
            }),

        new Guide(
            "Firework Rocket Farm",
            "Advanced. Rockets to boost your elytra.",
            new String[]{"Sugar cane farm (for paper)", "Gunpowder farm", "Crafting table", "Elytra"},
            new String[]{
                "Build a big sugar cane farm.",
                "Craft 3 sugar cane into 3 paper.",
                "Build a gunpowder farm and collect plenty of gunpowder.",
                "Craft 1 paper and 1 gunpowder into 3 firework rockets.",
                "Use 2 or 3 gunpowder in the recipe for rockets that boost you for longer.",
                "Fly with an elytra and right-click a rocket while gliding to speed up.",
                "Do not fly with rockets that have firework stars in them. The explosion hurts you."
            }),

        new Guide(
            "Mob Grinder (XP Farm)",
            "Advanced. Fast XP, bones, string and more.",
            new String[]{"Lots of building blocks", "Water buckets", "Hoppers and a chest", "Sword (Looting is a bonus)"},
            new String[]{
                "Build several dark floors that mobs can spawn on, with no torches.",
                "Add water channels on every floor to push the mobs to one drop.",
                "Make the drop about 22 blocks. Most mobs survive on a sliver of health.",
                "At the bottom, hit each mob once with your sword so you get the XP and the loot. Mobs killed only by the fall give no XP.",
                "Put hoppers under the kill spot and run them into a chest.",
                "Stand at an AFK spot 24 or more blocks away while mobs spawn.",
                "A sword with Looting gives more drops."
            }),

        new Guide(
            "Gold Farm",
            "Advanced. Gold from zombified piglins.",
            new String[]{"Obsidian for a Nether portal", "Flint and steel", "Water buckets", "Hoppers and a chest", "Building blocks"},
            new String[]{
                "Build a large Nether portal high in the Overworld sky.",
                "Zombified piglins sometimes spawn from the portal blocks.",
                "Build a platform around the portal and use water to push them to one spot.",
                "Drop them into a kill chamber with hoppers below.",
                "Run the hoppers into a chest. They drop gold nuggets and sometimes gold ingots.",
                "Smelt 9 gold nuggets into one ingot by crafting them."
            }),

        new Guide(
            "Villager Breeder",
            "Advanced. More villagers for trading.",
            new String[]{"2 villagers", "Beds (more than villagers)", "Bread, carrots, potatoes or beetroot", "Boats or minecarts", "Fences or walls"},
            new String[]{
                "Bring 2 villagers into a room with walls and a roof so zombies cannot get in.",
                "Add more beds than villagers. A free bed is needed for a baby to be born.",
                "Throw food on the floor in front of them. They need about 3 bread or 12 carrots, potatoes or beetroot.",
                "Hearts appear and a baby villager is born.",
                "Babies take about 20 minutes to grow up.",
                "Give each adult a workstation so they get a job and start trading.",
                "Keep breeding to grow your trading hall."
            }),

        new Guide(
            "Tree Farm",
            "Wood and saplings without searching for trees.",
            new String[]{"Saplings", "Dirt or grass blocks", "Bone meal", "Axe", "Torches"},
            new String[]{
                "Clear a flat area and plant saplings on dirt or grass with a few blocks of space between them.",
                "Add torches so the saplings get enough light to grow.",
                "Use bone meal to grow the trees faster.",
                "Chop the logs with an axe. Leave the dirt and replant.",
                "Break the leaves to collect more saplings and sometimes apples.",
                "Craft logs into planks and sticks."
            })
    };
}
