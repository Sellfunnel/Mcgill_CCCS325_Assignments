package com.example.moviefinal;


import java.util.ArrayList;

public class DataSource {

    private static final String MIYAZAKI = "Hayao Miyazaki";
    private static final String ISAO = "Isao Takahata";

    private static final int[] IMAGEID = {R.drawable.spiritedaway, R.drawable.myneighbortotoro, R.drawable.howlsmovingcastle,
            R.drawable.princessmononoke, R.drawable.ponyo, R.drawable.kikideliveryservice, R.drawable.whisperoftheheart,
            R.drawable.nausicaaofthevalley, R.drawable.thewindrises, R.drawable.graveofthefireflies, R.drawable.thecatreturns,
            R.drawable.arrietty, R.drawable.whenmarniewasthere, R.drawable.porcorosso, R.drawable.fromuponpoppyhill, R.drawable.talesfromearthsea,
            R.drawable.castleinthesky, R.drawable.oceanwaves, R.drawable.taleofprincesskaguya, R.drawable.onlyyesterday, R.drawable.pompoko};

    private static final String[] TITLE = {"Spirited Away", "My Neighbor Totoro", "Howl's Moving Castle", "Princess Mononoke", "Ponyo",
            "Kiki's Delivery Service", "Whisper of the Heart", "Nausicaa of the Valley of the Winds", "The Wind Rises",
            "Grave of the Fireflies", "The Cat Returns", "The Secret World of Arrietty", "When Marnie was There",
            "Porco Rosso", "From up on Poppy Hill", "Tales from Earthsea", "Castle in the Sky", "Ocean Waves",
            "The Tale of Princess Kaguya", "Only Yesterday", "Pom Poko"};

    private static final String[] DIRECTOR = {MIYAZAKI, MIYAZAKI, MIYAZAKI, MIYAZAKI, MIYAZAKI, MIYAZAKI, "Yoshifumi Kondo",
            MIYAZAKI, MIYAZAKI, ISAO, "Hiroyuki Morita", "Hiromasa Yonebayashi", "Hiromasa Yonebayashi",
            MIYAZAKI, "Goro Miyazaki", "Goro Miyazaki", MIYAZAKI, "Tomomi Mochizuki", ISAO, ISAO, ISAO};

    private static final String[] STARS = {"Rumi Hiiragi, Miyu Natsuki, Takashi Naito, Yasuko Sawaguchi, Tatsuya Gashuin",
            "Noriko Hidaka, Chika Sakamoto, Shigesato Itoi, Sumi Shimamoto, Tanie Kitabayashi",
            "Chieko Baisho, Takuya Kimura, Akihiro Miwa, Tatsuya Gashuin, Ryunosuke Kamiki",
            "Yoji Matsuda, Yuriko Ishida, Yuko Tanaka, Kaoru Koboyashi, Masahiko Nishimura",
            "Tomoko Yamaguchi, Kazushige Nagashima, Yuki Amami, George Tokoro, Hiroki Doi",
            "Minami Takayama, Reu Sakuma, Keiko Toda, Kappei Yamaguchi, Mieko Nobusawa",
            "Yoko Honna, Kazuo Takahashi, Takashi Tachibana, Shigeru Muroi, Shigeru Tsuyuguchi",
            "Sumi Shimamoto, Mahito Tsujimura, Hisako Kyoda, Goro Naya, Ichiro Nagai",
            "Hideaki Anno, Miori Takimoto, Hidetoshi Nishijima, Masahiko Nishimura, Stephen Alpert",
            "Tsutomu Tatsumi, Ayano Shiraishi, Yoshiko Shinohara, Akemi Yamaguchi, Kozo Hashida",
            "Chizuru Ikewaki, Yoshihiko Hakamada, Aki Maeda, Takayuki Yamada, Hitomi Sato",
            "Mirai Shida, Ryunosuke Kamiki, Shinobu Otake, Keiko Takeshita, Tatsuya Fujiwara",
            "Sara Takatsuki, Kasumi Arimura, Nanako Matsushima, Susumu Terajima, Toshie Negishi",
            "Shuichiro Moriyama, Tokiko Kato, Sanshi Katsura, Tsunehiko Kamijo, Akemi Okamura",
            "Masami Nagasawa, Junichi Okada, Keiko Takeshita, Yuriko Ishida, Rumi Hiiragi",
            "Junichi Okada, Aoi Teshima, Bunta Sugawara, Yuko Tanaka, Teruyuki Kagawa",
            "Mayumi Tanaka, Keiko Yokozawa, Kotoe Hatsui, Minori Terada, Fujio Tokita",
            "Nobuo Tobita, Yoko Sakamoto, Toshihiko Seki, Kae Araki, Hikaru Midorikawa",
            "Aki Asakura, Kengo Kora, Takeo Chii, Nobuko Miyamoto, Atsuko Takahata",
            "Miki Imai, Toshiro Yanagiba, Yoko Honna, Michie Terada, Masahiro Ito",
            "Kokondei Shinchou, Makoto Nonomura, Yuriko Ishida, Norihei Miki, Nijiko Kiyokawa"};

    private static final String[] DESCRIPTION = {"Chihiro wanders into a magical world where a witch rules - and those who disobey her are turned into animals.",
            "While spending a summer in the Japanese countryside with their father, two young sisters befriend mystical creatures who live in the nearby forest.",
            "Teenager Sophie works at her late father's hat shop in a humdrum town, but things get interesting when she's transformed into an elderly woman.",
            "A prince infected with a lethal curse sets off to find a cure and lands in the middle of a battle between a mining town and the animals of the forest.",
            "A 5-year-old boy names Sosuke forges a friendship with a goldfish princess named Ponyo, who desperately wants to become human.",
            "In the animated adventure, a young witch moves away from her family to practice her craft, but she finds that making new friends is difficult.",
            "After learning that all her library books were previously borrowed by the same person, schoolgirl Shizuku sets out to meet him and follow her dreams.",
            "Facing the destruction of her planet's natural resources, warrior princess Nausicaa rallies her people against an evil queen's rampaging army.",
            "Animator Hayao Miyazaki spins a decades-spanning tale inspired by the life of Jiro Horikoshi, designer of the World War II fighter plane the Zero.",
            "A young boy and his sister struggle to survive in Japan during World War II.",
            "Young Haru rescues a cat from being run over, but soon learns it's no ordinary feline; it happens to be the Prince of the Cats.",
            "When a tiny borrower named Arrietty makes friends with a young boy many times her size, she must also shield her family from his towering elders.",
            "Sent to spend the summer in a sleepy seaside town, sickly Anna befriends a curious girl living in a deserted villa. But is their connection real?",
            "When sky pirates terrorize the Adriatic Sea, this Italian pilot is the only one brave enough to take them on. Only catch; he's half-man, half-pig.",
            "Two high schoolers find hope as they fight to save an old wartime era clubhouse from destruction during the preparations fro the 1964 Tokyo Olympics.",
            "As their world decays, an Archmage guides a troubled prince with a dark side on a journey to find the source of evil and save the women they love.",
            "In the children's anime adventure, a young miner and a mysterious girl search for a long-lost island that's rumoured to hold great riches.",
            "College student Taku recalls transfer student Rikako's arrival two years agao, and the fateful summer that tested his bond with his friend Yutaka.",
            "A magical nymph plucked from a bamboo stalk rapidly grows up into a beautiful woman who is pursued by a stable of smitten suitors.",
            "From pineapples to first loves: the now-and-then tale of a 27-year-old woman from Tokyo as she takes a trip out of the city and down memory lane.",
            "Pushed out of their forests by human development, the wild tanuki of Tama Hills fight back with their space-shifting powers - if they can get it right."};

    private static final double[] PRICE = {10.99, 7.99, 10.99, 10.99, 8.99, 9.99, 6.99, 8.99, 7.99, 4.99,
            7.99, 8.99, 8.99, 5.99, 6.99, 7.99, 7.99, 5.99, 8.99, 5.99, 5.99};


    public static int[] getIMAGEID() {
        int[] imageIdClone = IMAGEID.clone();
        return imageIdClone;
    }

    public static String[] getTITLE() {
        String[] titleClone = TITLE.clone();
        return titleClone;
    }

    public static String[] getDIRECTOR() {
        String[] directorClone = DIRECTOR.clone();
        return directorClone;
    }

    public static String[] getSTARS() {
        String[] starsClone = STARS.clone();
        return starsClone;
    }

    public static String[] getDESCRIPTION() {
        String[] descriptionClone = DESCRIPTION.clone();
        return descriptionClone;
    }

    public static double[] getPRICE() {
        double[] priceClone = PRICE.clone();
        return priceClone;
    }

    public static ArrayList<Movie> getMovies(){
        ArrayList<Movie> movies = new ArrayList<>();

        for(int i = 0; i < TITLE.length; i++){
            movies.add(new Movie(TITLE[i],DIRECTOR[i],STARS[i], DESCRIPTION[i],PRICE[i],IMAGEID[i]));
        }

        return movies;
    }

}

