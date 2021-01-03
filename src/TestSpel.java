import java.util.ArrayList;

public class TestSpel {
    public static void main(String[] args) {
        /* Het is me nog niet gelukt het volledige spel functionerend te krijgen.
        Ik moet toegeven dat ik te veel hooi op mij vork heb genomen voor de tijd die ik beschikbaar had.
        Ik blijf hier aan verder werken na indienen.
         */
        // Alle werkende testklassen zijn aangeduid met een * //
        // Degene die nog niet compleet werken met -- //
        //Aanmaken van items die nodig zijn om de spelwereld te vullen
        // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Wapen speer = new Wapen("Speer", "Stick 'em with pointy end.", 10);
        GeestUsable foto = new GeestUsable("Foto", "Een foto van hoe het ziekenhuis er uit zag voor al.... dit", 10);
        GezondheidUsable crackers = new GezondheidUsable("Gezouten crackers", "Ze lijken op het eerste zicht op Tuc koekjes maar iets zegt je dat dit een knock-off is.", 5);
        Wapen stukGlas = new Wapen("Scherp stuk glas", "Waarschijnlijk afkomstig van een van de vele gesneuvelde ramen.", 5);
        Wapen schroevenDraaier = new Wapen("Schroevendraaier", "Kruiskop van het merk 'Philips'.", 7);
        Wapen pistool = new Wapen("Pistool", "Pistool van het model five-seven, belgische makelij.", 0);
        Wapen scalpel = new Wapen("Scalpel", "Het eens blinkende metaal is reeds dof geworden.", 12);
        GeestUsable sigaretten = new GeestUsable("Sigaretten", "'Marlboro orginal reds', Nog al een duffe geur maar het zal moeten volstaan", 15);
        GeestUsable redbull = new GeestUsable("Red Bull", "Energiedrankje dat eigenhandig je hart naar de knoppen helpt maar wel voor een tijdelijke opkikker zorgt", 8);
        GezondheidUsable paprika_chips = new GezondheidUsable("Paprika chips", "Blauw zakje van het merk Lays.", 4);
        GezondheidUsable noedels = new GezondheidUsable("Aiki instant noedels", "Thai sweet chicken flavour. Wel niet zo lekker zonder water", 8);
        GezondheidUsable frisdrank = new GezondheidUsable("Blikje lauwe frisdrank", "Als het niet koud is proef je de suiker beter.", 4);
        Item sleutel1 = new Item("Zwart geblakerde sleutel", "Waar hij normaal zou moeten blinken is hij nu aangelsagen met roet");
        Item sleutel2 = new Item("Bol van een deurknop", "Een bronzen handvat van een deurknop. Het mist een deel");
        Item sleutel2_5 = new Item("Staaf van een deurknop", "Een lange bronzen staaf. Hier mist nog een deel");
        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Toevoegen van items aan een Array voor later gebruik
        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        ArrayList<Item> lijstAlleItems = new ArrayList<>();
        lijstAlleItems.add(speer);
        lijstAlleItems.add(foto);
        lijstAlleItems.add(crackers);
        lijstAlleItems.add(stukGlas);
        lijstAlleItems.add(schroevenDraaier);
        lijstAlleItems.add(pistool);
        lijstAlleItems.add(scalpel);
        lijstAlleItems.add(sigaretten);
        lijstAlleItems.add(redbull);
        lijstAlleItems.add(paprika_chips);
        lijstAlleItems.add(noedels);
        lijstAlleItems.add(frisdrank);
        ArrayList<Item> keyItems = new ArrayList<>();
        keyItems.add(sleutel1);
        keyItems.add(sleutel2);
        keyItems.add(sleutel2_5);

        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Aanmaak van containers
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Container c1 = new Container("Kleine lade");
        Container c2 = new Container("Grote lade");
        Container c3 = new Container("Deur");
        ArrayList<Container> lijstComponenten = new ArrayList<>();
        lijstComponenten.add(c1);
        lijstComponenten.add(c2);
        lijstComponenten.add(c3);
        int plaatsingsPercentage = 10;
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Aanmaak Meubels
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Meubel meubel1 = new Meubel("Antieke medicijnenkast");
        Meubel meubel2 = new Meubel("Nachtkastje");
        Meubel meubel3 = new Meubel("Kleerkast");
        Meubel meubel4 = new Meubel("Ladekast");
        ArrayList<Meubel> lijstMeubels = new ArrayList<>();
        lijstMeubels.add(meubel1);
        lijstMeubels.add(meubel2);
        lijstMeubels.add(meubel3);
        lijstMeubels.add(meubel4);
        for (Meubel meubel : lijstMeubels) { // * // ( ArrayList )
            meubel.vulContainerNiveau1(lijstAlleItems, keyItems, lijstComponenten, plaatsingsPercentage); // * // (Random , ArrayList )
            meubel.vulMeubel(lijstComponenten); // * // ( ArrayList , HashMap , Random )
        }
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Aanmaak kamers en gangen
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Kamer start = new Kamer("Operatie Kamer", 1, new int[]{-1, 2, 3, -1});
        Kamer ka2 = new Kamer("Opslag", 2, new int[]{-1, -1, -1, 1});
        Kamer ka3 = new Kamer("Wachtzaal", 6, new int[]{-1, -1, -1, 4});
        Kamer ka4 = new Kamer("Inkomhal", 7, new int[]{-1, 4, -1, -1});
        Kamer ka5 = new Kamer("Recreatie ruimte", 8, new int[]{-1, -1, 5, -1});
        Kamer ka6 = new Kamer("Keuken", 9, new int[]{5, -1, -1, -1});
        Gang g1 = new Gang(3, new int[]{1, 50, 4, 5});
        Gang g2 = new Gang(4, new int[]{3, 6, -1, 7});
        Gang g3 = new Gang(5, new int[]{8, 3, 9, -1});
        ArrayList<Kamer> lijstLocaties = new ArrayList<>();
        lijstLocaties.add(start);
        lijstLocaties.add(ka2);
        lijstLocaties.add(ka3);
        lijstLocaties.add(ka4);
        lijstLocaties.add(ka5);
        lijstLocaties.add(ka6);
        lijstLocaties.add(g1);
        lijstLocaties.add(g2);
        lijstLocaties.add(g3);
        ka2.vulKamerMeubels(lijstMeubels); // * //
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Aanmaak map
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Map m1 = new Map("map1");
        m1.GenereerMap(lijstLocaties); // * // (ArrayList , HashMap )
        m1.setHuidigelocatie(start);
        m1.getHuidigelocatie().vulKamerMeubels(lijstMeubels);
        for (Meubel m : m1.getHuidigelocatie().getMeubilair()) {
            m.vulMeubel(lijstComponenten);
        }
        for (Meubel m : m1.getHuidigelocatie().getMeubilair()) {
            m.vulContainerNiveau1(lijstAlleItems, keyItems, lijstComponenten, plaatsingsPercentage);
        }
        m1.getBeschrijvingHuidigeLocatie(); // * // (ArrayList)
        m1.Verplaats(); // * // < ---- hier worden drie verschillende functies gebruikt die worden gestart in Verplaats() (ArrayList,Iterator,Switch)
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Aanmaak Rollen
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Rol rol1 = new Rol("Dokter", "Tijdens het opruimen van de operatiekamer verloor je plots het bewustzijn. Je werd wakker met een ontzettende hoofdpijn in een plas van wat je denkt dat het je eigen bloed is.", 80, 110, 5);
        Rol rol2 = new Rol("Verpleegster", "Bij het verdelen van de medicatie op de paliatieve zorg vielen de meerderheid van de lichten uit. Eén enkel licht dat nog half aan het flikkeren was onthulde wat leek op het silhouette van een voorover gebogen man. Je knipperde twee maal met je ogen en het silhouette verdween. Je knipperde een derde maal en viel met een enorme smak op de vloer van de gang.", 70, 80, 8);
        Rol rol3 = new Rol("Patient", "Je lag 's avonds laat nog wat TV te kijken in je kamer(iets van twee broers die escape rooms maken voor bekende vlamingen). Het programma werd onderbroken door een boodschap van het journaal. Het anker begon te vertellen over enkele auto's die in het Brusselse in brand waren gestoken en toen viel het je op dat de presentator je helemaal niet bekend voor kwam, beter nog hij zag er helemaal niet geschikt uit als nieuwsanker. De man stopte met het voorlezen van het bericht en begon spontaan te grinniken.Alles werd donker...", 40, 80, 8);
        ArrayList<Rol> rollenLijst = new ArrayList<>();
        rollenLijst.add(rol1);
        rollenLijst.add(rol2);
        rollenLijst.add(rol3);
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Aanmaak Vijanden
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Vijand v1 = new Vijand("Zombie", "De geur van rottend vlees vult de lucht rondom je. Het geluid van slepende ledematen en pijnlijke kreunen dwalen langzaam door de kamer. Voor je verschijnt uit de schaduw iets wat lijkt op een persoon die al enkele weken is weggerot.", 30, 15);
        Vijand v2 = new Vijand("Schreeuwer", "Een infantiel geluid galmt door de kamer. In je ooghoeken kan je nog net het silhouette van een foetus uitmaken.", 15, 5);
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Aanmaak Player
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Player p1 = new Player("Lander", rol1, start);
        //  p1.doorzoekMeubel(lijstMeubels.get(0)); // -- //
        //  p1.maakKeuzeContainer(lijstMeubels.get(0));  // -- //
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Aanmaak Spel
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Spel s1 = new Spel(p1, m1); // Hier komt het spel samen. Wat werkt tot nu toe is de navigatie van kamer naar kamer
        s1.GeefOpties(); // De hiervoor gebruikte functies vind je terug in de klasse Spel.
        // ------------>! Enkel het verplaatsen werkt tot nu toe. Het zoeken wordt nog aan gewerkt !< -------------------//
        // Als je het spel tot nu toe wil testen is het het beste dat je regel 113 in comment zet //
    }
}
