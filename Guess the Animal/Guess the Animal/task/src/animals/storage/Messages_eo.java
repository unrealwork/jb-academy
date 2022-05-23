package animals.storage;

import java.util.ListResourceBundle;

import static animals.storage.MessageKeys.BASE_ANIMAL_REQUEST;
import static animals.storage.MessageKeys.BYE;
import static animals.storage.MessageKeys.ENTER_ANIMAL;
import static animals.storage.MessageKeys.FACTS_ABOUT;
import static animals.storage.MessageKeys.FACT_CONFIRM;
import static animals.storage.MessageKeys.FACT_CORRECT_QUESTION;
import static animals.storage.MessageKeys.FACT_DESCRIPTION;
import static animals.storage.MessageKeys.FACT_TEMPLATE;
import static animals.storage.MessageKeys.GAME_INTRO;
import static animals.storage.MessageKeys.GREETING_EVENING;
import static animals.storage.MessageKeys.GREETING_MORNING;
import static animals.storage.MessageKeys.LIST_TITLE;
import static animals.storage.MessageKeys.MENU_EXIT;
import static animals.storage.MessageKeys.MENU_GAME;
import static animals.storage.MessageKeys.MENU_INTRO;
import static animals.storage.MessageKeys.MENU_LIST;
import static animals.storage.MessageKeys.MENU_PRINT_TREE;
import static animals.storage.MessageKeys.MENU_SEARCH;
import static animals.storage.MessageKeys.MENU_STAT;
import static animals.storage.MessageKeys.NEW_ANIMAL;
import static animals.storage.MessageKeys.NEW_KNOWLEDGE;
import static animals.storage.MessageKeys.NO;
import static animals.storage.MessageKeys.NOT_SURE;
import static animals.storage.MessageKeys.NO_FACTS;
import static animals.storage.MessageKeys.PLAY_AGAIN;
import static animals.storage.MessageKeys.STAT_AVG_DEPTH;
import static animals.storage.MessageKeys.STAT_HEIGHT;
import static animals.storage.MessageKeys.STAT_MIN_DEPTH;
import static animals.storage.MessageKeys.STAT_ROOT_NODE;
import static animals.storage.MessageKeys.STAT_TITLE;
import static animals.storage.MessageKeys.STAT_TOTAL_ANIMALS;
import static animals.storage.MessageKeys.STAT_TOTAL_NODES;
import static animals.storage.MessageKeys.STAT_TOTAL_STATEMENTS;
import static animals.storage.MessageKeys.YES;

public class Messages_eo extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {GREETING_MORNING, "Bonan matenon!"},
                {GREETING_MORNING, "Bonan tagon!"},
                {GREETING_EVENING, "Bonan vesperon!"},
                {BYE, new String[] {
                        "Ĝis!",
                        "Ĝis revido!",
                        "Estis agrable vidi vin!"}
                },
                {FACT_TEMPLATE, "Indiku fakton, kiu distingas {0} de {1}.\n" +
                        "La frazo devas esti de la formato: 'Ĝi ...'."},
                {FACT_CONFIRM, "La ekzemploj de aserto:\n" +
                        "- Ĝi povas flugi\n" +
                        "- Ĝi havas kornojn\n" +
                        "- Ĝi estas mamulo"},
                {NOT_SURE, new String[] {
                        "Bonvolu enigi jes aŭ ne.",
                        "Amuze, mi ankoraŭ ne komprenas, ĉu jes aŭ ne?",
                        "Pardonu, devas esti jes aŭ ne.",
                        "Ni provu denove: ĉu jes aŭ ne?",
                        "Pardonu, ĉu mi rajtas demandi vin denove: ĉu tio estis jes aŭ ne?"}
                },
                {YES, new String[] {"j", "jes", "certe"}},
                {NO, new String[] {"n", "ne"}},
                {FACT_CORRECT_QUESTION, "Ĉu la aserto ĝustas por la {0}?"},
                {FACT_DESCRIPTION, "Mi lernis la jenajn faktojn pri bestoj:\n" +
                        "- {0}.\n" +
                        "- {1}.\n" +
                        "Mi povas distingi ĉi tiujn bestojn per la demando:\n" +
                        "- {2}"
                },
                {BASE_ANIMAL_REQUEST, "Mi volas lerni pri bestoj.\n" +
                        "Kiun beston vi plej ŝatas?"
                },
                {GAME_INTRO, "Mirinde! Mi lernis tiom multe pri bestoj!\n" +
                        "Ni ludu!\n" +
                        "Vi pensu pri besto, kaj mi divenos ĝin.\n" +
                        "Premu enen kiam vi pretas."
                },
                {NEW_ANIMAL, "Mi rezignas. Kiun beston vi havas en la kapo?"},
                {NEW_KNOWLEDGE, "Nice! Mi lernis tiom multe pri bestoj!"},
                {PLAY_AGAIN, "Ĉu vi volas provi denove?"},
                {MENU_GAME, "Ludi la divenludon"},
                {MENU_INTRO, "Bonvenon al la sperta sistemo de la besto!\n" +
                        "\n" +
                        "Kion vi volas fari:\n" +
                        "\n"
                },
                {MENU_LIST, "Listo de ĉiuj bestoj"},
                {MENU_SEARCH, "Serĉi beston"},
                {MENU_STAT, "Kalkuli statistikojn"},
                {MENU_PRINT_TREE, "Printi la Sciarbon"},
                {MENU_EXIT, "Eliri"},
                {STAT_TITLE, "La statistiko de la Scio-Arbo\n" +
                        "\n"
                },
                {STAT_ROOT_NODE, "- radika nodo                  {0}"},
                {STAT_TOTAL_NODES, "- totala nombro de nodoj       {0,number,integer}"},
                {STAT_TOTAL_ANIMALS, "- totala nombro de bestoj      {0,number,integer}"},
                {STAT_TOTAL_STATEMENTS, "- totala nombro de deklaroj    {0,number,integer}"},
                {STAT_HEIGHT, "- alteco de la arbo            {0,number,integer}"},
                {STAT_MIN_DEPTH, "- minimuma profundo            {0,number,integer}"},
                {STAT_AVG_DEPTH, "- averaĝa profundo             {0,number,##0.0}"},
                {LIST_TITLE, "Jen la bestoj, kiujn mi konas:"},
                {ENTER_ANIMAL, "Enigu la nomon de besto:"},
                {FACTS_ABOUT, "Facts about the {0}:"},
                {NO_FACTS, "No facts about the {0}."}
        };
    }
}
