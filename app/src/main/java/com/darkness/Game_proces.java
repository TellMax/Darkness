package com.darkness;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Game_proces extends AppCompatActivity
{
    //глобальные перменные
    int playercorex = 0;
    int playercorey = 0;
    int khod = 0;
    String[][] map = new String [10][10];
    String[][] Void = new String [10][10];

    int choise = 0;
    int moove = 0;
    ImageButton Exit;
    ImageButton upLeft;
    ImageButton up;
    ImageButton upRight;
    ImageButton left;
    ImageButton right;
    ImageButton downLeft;
    ImageButton down;
    ImageButton downRight;
    ImageButton flashbang;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_proces);

        Exit();
        UpLeft();
        Up();
        UpRigth();
        Left();
        flasBang();
        Rigt();
        DownLeft();
        Down();
        DownRigt();
        new Thread(()->{new Game().GP();}).start();
    }

    // выход
    protected void Exit()
    {
        Exit = findViewById(R.id.exit);

        Exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Game_proces.this, MainActivity.class));
            }
        });
    }

    // кнопки игры
    protected void UpLeft()
    {
        upLeft = findViewById(R.id.upleft);

        upLeft.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                map[playercorex][playercorey] = "░";
                map[--playercorex][--playercorey] = "#";
                khod = 1;
            }
        });
    }

    protected void Up()
    {
        up = findViewById(R.id.up);

        up.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                map[playercorex][playercorey] = "░";
                map[playercorex][--playercorey] = "#";
                khod = 1;
            }
        });
    }

    protected void UpRigth()
    {
        upRight = findViewById(R.id.upright);

        upRight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                map[playercorex][playercorey] = "░";
                map[++playercorex][--playercorey] = "#";
                khod = 1;
            }
        });
    }

    protected void Left()
    {
        left = findViewById(R.id.left);

        left.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                map[playercorex][playercorey] = "░";
                map[--playercorex][playercorey] = "#";
                khod = 1;
            }
        });
    }

    protected void Rigt()
    {
        right = findViewById(R.id.right);

        right.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                map[playercorex][playercorey] = "░";
                map[++playercorex][playercorey] = "#";
                khod = 1;
            }
        });
    }

    protected void DownLeft()
    {
        downLeft = findViewById(R.id.downleft);

        downLeft.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                map[playercorex][playercorey] = "░";
                map[--playercorex][++playercorey] = "#";
                khod = 1;
            }
        });
    }

    protected void Down()
    {
        down = findViewById(R.id.down);

        down.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                map[playercorex][playercorey] = "░";
                map[playercorex][++playercorey] = "#";
                khod = 1;
            }
        });
    }

    protected void DownRigt()
    {
        downRight = findViewById(R.id.downright);

        downRight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                map[playercorex][playercorey] = "░";
                map[++playercorex][++playercorey] = "#";
                khod = 1;
            }
        });
    }

    protected void flasBang()
    {
        flashbang = findViewById(R.id.middle);

        flashbang.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                choise = 2;
                khod = 1;
            }
        });
    }


    public class Game
    {
        TextView[] pole = new TextView[]
                {
                        findViewById(R.id.pole0),
                        findViewById(R.id.pole1),
                        findViewById(R.id.pole2),
                        findViewById(R.id.pole3),
                        findViewById(R.id.pole4),
                        findViewById(R.id.pole5),
                        findViewById(R.id.pole6),
                        findViewById(R.id.pole7),
                        findViewById(R.id.pole8),
                        findViewById(R.id.pole9),
                };

        //-Отрисовка поля
        public void otri(String[][] map)
        {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    int i, j = 0;
                    for (i = 0; i < 10; i++){
                        StringBuilder pep = new StringBuilder();
                        for(j = 0; j < 10; j++){
                            pep.append(map[i][j]).append(" ");
                        }
                        pole[i].setText(pep.toString());
                        pep.delete(0, 9);
                    }
                }
            });
        }
        //-

        /// - Генерация
        public void gen(String[][] map)
        {
            Random random = new Random();
            int i, j = 0;

            //Пустые клетки
            for (i = 0; i < 10; i++)
            {
                for(j = 0; j < 10; j++)
                {
                    map[j][i] = "░";
                }
            }
            //Стены по горизонтали
            for (i = 0; i < 10; i++)
            {
                map[i][0] = "█";
                map[i][9] = "█";
            }

            //Стены по вертикали
            for (i = 0; i < 10; i++)
            {
                map[0][i] = "█";
                map[9][i] = "█";
            }

            //Колонна
            int help = 1;

            for (i = 0; i < help; i++)
            {
                int helpgen = random.nextInt(6) + 2;
                int helpgen2 = random.nextInt(6) + 2;
                map[helpgen][helpgen2] = "█";

                map[helpgen + 1][helpgen2 + 1] = "█";
                map[helpgen - 1][helpgen2 + 1] = "█";
                map[helpgen + 1][helpgen2 - 1] = "█";
                map[helpgen - 1][helpgen2 - 1] = "█";
                map[helpgen + 1][helpgen2] = "█";
                map[helpgen - 1][helpgen2] = "█";
                map[helpgen][helpgen2 + 1] = "█";
                map[helpgen][helpgen2 - 1] = "█";
            }
        }

        public void GP()
        {
            //- Переменные
            int gamerun = 1;
            int score = 0;
            //-

            /// -

            /// - списки мобов / боссов
            String[][] mobsnames =
                    {
                            {"Пешка","P"},
                            {"Слоненок","S"},
                            {"Слепой король","K"},
                            {"Игрок","#"}
                    };

            int corekindx = 1;
            int corekingy = 1;
            int corepeshkax = 1;
            int corepeshkay = 1;
            int coreslonx = 1;
            int coreslony = 1;
            /// -

            //- Логика игры
            while (gamerun == 1)
            {
                Random random = new Random();
                gen(map);

                //Игрок
                int ggen = 1;

                while(ggen == 1)
                {
                    playercorex = random.nextInt(8) + 1;
                    playercorey = random.nextInt(8) + 1;

                    if (map[playercorex][playercorey] != "█")
                    {
                        map[playercorex][playercorey] = "#";
                        ggen = 0;
                    }
                }

                ggen = 1;

                while(ggen == 1)
                {
                    corekindx = random.nextInt(7) + 1;
                    corekingy = random.nextInt(7) + 1;

                    if (map[corekindx][corekingy] != "█")
                    {
                        map[corekindx][corekingy] = "K";
                        ggen = 0;
                    }
                }


                ggen = 1;

                while (ggen == 1)
                {
                    corepeshkax = random.nextInt(8) + 1;
                    corepeshkay = random.nextInt(8) + 1;

                    if (map[corepeshkax][corepeshkay] != "█")
                    {
                        map[corepeshkax][corepeshkay] = "P";
                        ggen = 0;
                    }
                }

                ggen = 1;

                while (ggen == 1)
                {
                    coreslonx = random.nextInt(8) + 1;
                    coreslony = random.nextInt(8) + 1;

                    if (map[coreslonx][coreslony] != "█")
                    {
                        map[coreslonx][coreslony] = "S";
                        ggen = 0;
                    }
                }


                int round = 1;

                while (round == 1)
                {
                    if (khod == 1)
                    {
                        //Ход мобов

                        // ход короля
                        int hodkor = 1;
                        while (hodkor == 1) {
                            int nap = random.nextInt(7) + 1;
                            if (nap == 1 && map[corekindx - 1][corekingy] != "█") {
                                map[corekindx][corekingy] = "░";
                                corekindx--;
                                nap = 0;
                                hodkor--;
                            } else if (nap == 2 && map[corekindx + 1][corekingy] != "█") {
                                map[corekindx][corekingy] = "░";
                                corekindx++;
                                nap = 0;
                                hodkor--;
                            } else if (nap == 3 && map[corekindx][corekingy - 1] != "█") {
                                map[corekindx][corekingy] = "░";
                                corekingy--;
                                nap = 0;
                                hodkor--;
                            } else if (nap == 4 && map[corekindx][corekingy + 1] != "█") {
                                map[corekindx][corekingy] = "░";
                                corekingy++;
                                nap = 0;
                                hodkor--;
                            } else if (nap == 5 && map[corekindx - 1][corekingy - 1] != "█") {
                                map[corekindx][corekingy] = "░";
                                corekindx--;
                                corekingy--;
                                nap = 0;
                                hodkor--;
                            } else if (nap == 6 && map[corekindx - 1][corekingy + 1] != "█") {
                                map[corekindx][corekingy] = "░";
                                corekindx--;
                                corekingy++;
                                nap = 0;
                                hodkor--;
                            } else if (nap == 7 && map[corekindx + 1][corekingy - 1] != "█") {
                                map[corekindx][corekingy] = "░";
                                corekindx++;
                                corekingy--;
                                nap = 0;
                                hodkor--;
                            } else if (nap == 8 && map[corekindx + 1][corekingy + 1] != "█") {
                                map[corekindx][corekingy] = "░";
                                corekindx++;
                                corekingy++;
                                nap = 0;
                                hodkor--;
                            }
                        }

                        map[corekindx][corekingy] = "K";

                        // ход пешки
                        int hodpesh = 1;
                        while (hodpesh == 1) {
                            int razx = corepeshkax - playercorex;
                            int razy = corepeshkay - playercorey;

                            int nap = 0;

                            if (Math.abs(razx) > Math.abs(razy)) {
                                if (razx > 0)
                                    nap = 1;

                                else
                                    nap = 2;
                            } else {
                                if (razy > 0)
                                    nap = 3;

                                else
                                    nap = 4;
                            }

                            if (nap == 1) {
                                map[corepeshkax][corepeshkay] = "░";
                                corepeshkax--;
                                hodpesh--;
                            } else if (nap == 2) {
                                map[corepeshkax][corepeshkay] = "░";
                                corepeshkax++;
                                hodpesh--;
                            } else if (nap == 3) {
                                map[corepeshkax][corepeshkay] = "░";
                                corepeshkay--;
                                hodpesh--;
                            } else if (nap == 4) {
                                map[corepeshkax][corepeshkay] = "░";
                                corepeshkay++;
                                hodpesh--;
                            }
                        }

                        map[corepeshkax][corepeshkay] = "P";

                        // ход слона
                        int hodslo = 1;
                        while (hodslo == 1) {
                            int nap = 0;

                            if (playercorex < coreslonx) {
                                if (playercorey < coreslony)
                                    nap = 1;

                                else
                                    nap = 2;
                            } else {
                                if (playercorey < coreslony)
                                    nap = 3;

                                else
                                    nap = 4;
                            }

                            if (nap == 1) {
                                map[coreslonx][coreslony] = "░";
                                coreslonx--;
                                coreslony--;
                                nap = 0;
                                hodslo--;
                            } else if (nap == 2) {
                                map[coreslonx][coreslony] = "░";
                                coreslonx--;
                                coreslony++;
                                nap = 0;
                                hodslo--;
                            } else if (nap == 3) {
                                map[coreslonx][coreslony] = "░";
                                coreslonx++;
                                coreslony--;
                                nap = 0;
                                hodslo--;
                            } else if (nap == 4) {
                                map[coreslonx][coreslony] = "░";
                                coreslonx++;
                                coreslony++;
                                nap = 0;
                                hodslo--;
                            }
                        }

                        map[coreslonx][coreslony] = "S";

                        if (choise == 2) {
                        }

                        otri(map);
                        score++;

                        khod = 0;
                    }

                    int flag = 0;
                    for(int i = 0; i < 10; i++)
                    {
                        for(int j = 0; j < 10; j++)
                        {
                            if(map[i][j] == "#")
                            {
                                flag = 1;
                            }
                        }
                    }

                    if(flag == 0)
                    {
                        round = 0;
                        gamerun = 0;
//                            System.out.println("Вы продержались - " + score + " ходов");
                        otri(map);
                    }
                }
            }
        }
    }
}