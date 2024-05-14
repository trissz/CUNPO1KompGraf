#include <iostream>
#include <iomanip>
#include <fstream>
#include <iomanip>
#include <math.h>
#include <cstdlib>
#include <ctime>

using namespace std;

const int height = 100;
const int width = 100;

struct color
{
    int r, g, b;
};

color image[1000][1000];

void MakeRandomImage(int h, int w, int maximum_color_value, ofstream& image_out);
void AddRedFilterToImage(string image_name, int add_value, ifstream& image_in, ofstream& image_out);
void AddGreenFilterToImage(string image_name, int add_value, ifstream& image_in, ofstream& image_out);
void AddBlueFilterToImage(string image_name, int add_value, ifstream& image_in, ofstream& image_out);
void ConvolveImage(string image_name, ifstream& image_in, ofstream& image_out);
void MakeTransition(int h, int w, int max_color_value, int mul, int add_differential, int max_transition_iteration, int goal_red, int goal_green, int goal_blue, ofstream& image_out);

int main()
{
    setlocale(LC_ALL,"");

    cout << "Képfeldolgozási folyamatok megkezdése. . . . .\n\n";

    ifstream image_in_stream;
    ofstream image_out_stream;

    image_out_stream.open("test_image.ppm");

    image_out_stream << "P3" << endl;
    image_out_stream << 255 << " " << 255 << endl;
    image_out_stream << 255 << endl;

    for ( int i = 1; i <= 255; i ++ )
    {
        for ( int j = 1; j <= 255; j ++ )
        {
            image_out_stream << i << " " << j << " " << i << endl;
        }
    }

    image_out_stream.close();

    ConvolveImage("landscape", image_in_stream, image_out_stream);

    /* Mûveletek */

    //MakeRandomImage(height, width, 255, image_out_stream);
    //AddRedFilterToImage("landscape", 100, image_in_stream, image_out_stream);
    //AddGreenFilterToImage("landscape", 100, image_in_stream, image_out_stream);
    //AddBlueFilterToImage("landscape", 100, image_in_stream, image_out_stream);
    //MakeTransition(300, 300, 20, 64, 224, 208, image_out_stream);
    MakeTransition(255, 255, 255, 10, 200, 64, 64, 224, 208, image_out_stream); //turkiz: rgb(64,224,208); pink: rgb(255,20,147)

    cout << "Képfeldolgozási folyamatok sikeresen végrehajtva.\n\n";

    system("pause");

    return 0;
}

void MakeRandomImage(int h, int w, int maximum_color_value, ofstream& image_out)
{
    srand(time(0));

    image_out.open("random_image.ppm");

    if ( image_out.is_open() )
    {
        image_out << "P3" << endl;

        image_out << w << " " << h << endl;

        image_out << maximum_color_value << endl;

        for ( int y = 0; y < h; y ++ )
        {
            for ( int x = 0; x < w; x ++ )
            {
                image_out << rand() % 256 << " " << rand() % 256 << " " << rand() % 256 << endl;
            }
        }
    }

    image_out.close();
}

void AddRedFilterToImage(string image_name, int add_value, ifstream& image_in, ofstream& image_out)
{
    image_in.open(image_name + ".ppm");
    image_out.open("red_filtered_" + image_name + ".ppm");

    if ( image_in.is_open() && image_out.is_open() )
    {
        string type;
        int w, h, maximum_color_value_of_the_image;

        image_in >> type >> w >> h >> maximum_color_value_of_the_image;

        image_out << type << endl;
        image_out << w << " " << h << endl;
        image_out << maximum_color_value_of_the_image << endl;

        int r, g, b;

        for ( int i = 0; i < h; i ++ )
        {
            for ( int j = 0; j < w; j ++ )
            {
                image_in >> r >> g >> b;

                if ( r + add_value <= maximum_color_value_of_the_image )
                {
                    r += add_value;
                }else r += maximum_color_value_of_the_image - (r + add_value);

                image_out << r << " " << g << " " << b << endl;
            }
        }
    }

    image_in.close();
    image_out.close();
}

void AddGreenFilterToImage(string image_name, int add_value, ifstream& image_in, ofstream& image_out)
{
    image_in.open(image_name + ".ppm");
    image_out.open("green_filtered_" + image_name + ".ppm");

    if ( image_in.is_open() && image_out.is_open() )
    {
        string type;
        int w, h, maximum_color_value_of_the_image;

        image_in >> type >> w >> h >> maximum_color_value_of_the_image;

        image_out << type << endl;
        image_out << w << " " << h << endl;
        image_out << maximum_color_value_of_the_image << endl;

        int r, g, b;

        for ( int i = 0; i < h; i ++ )
        {
            for ( int j = 0; j < w; j ++ )
            {
                image_in >> r >> g >> b;

                if ( g + add_value <= maximum_color_value_of_the_image )
                {
                    g += add_value;
                }else g += maximum_color_value_of_the_image - (g + add_value);

                image_out << r << " " << g << " " << b << endl;
            }
        }
    }

    image_in.close();
    image_out.close();
}

void AddBlueFilterToImage(string image_name, int add_value, ifstream& image_in, ofstream& image_out)
{
    image_in.open(image_name + ".ppm");
    image_out.open("blue_filtered_" + image_name + ".ppm");

    if ( image_in.is_open() && image_out.is_open() )
    {
        string type;
        int w, h, maximum_color_value_of_the_image;

        image_in >> type >> w >> h >> maximum_color_value_of_the_image;

        image_out << type << endl;
        image_out << w << " " << h << endl;
        image_out << maximum_color_value_of_the_image << endl;

        int r, g, b;

        for ( int i = 0; i < h; i ++ )
        {
            for ( int j = 0; j < w; j ++ )
            {
                image_in >> r >> g >> b;

                if ( b + add_value <= maximum_color_value_of_the_image )
                {
                    b += add_value;
                }else b += maximum_color_value_of_the_image - (b + add_value);

                image_out << r << " " << g << " " << b << endl;
            }
        }
    }

    image_in.close();
    image_out.close();
}

void ConvolveImage(string image_name, ifstream& image_in, ofstream& image_out)
{
    int n = 3, m = 3;

    float mul[n][m];

    mul[0][0] = 0.25;
    mul[0][1] = 0.0;
    mul[0][2] = -0.25;
    mul[1][0] = 0.5;
    mul[1][1] = 0.0;
    mul[1][2] = -0.5;
    mul[2][0] = 0.25;
    mul[2][1] = 0.0;
    mul[2][2] = -0.5;

    image_in.open(image_name + ".ppm");
    image_out.open("convolved_" + image_name + ".ppm");

    if ( image_in.is_open() && image_out.is_open() )
    {
        string type;
        int w, h, maximum_color_value_of_the_image;

        image_in >> type >> w >> h >> maximum_color_value_of_the_image;

        for ( int i = 0; i < h; i ++ )
        {
            for ( int j = 0; j < w; j ++ )
            {
                image_in >> image[i][j].r >> image[i][j].g >> image[i][j].b;
            }
        }

        float r_sum = 0, g_sum = 0, b_sum = 0;

        for ( int i = n / 2; i < h - n / 2; i ++ )
        {
            for ( int j = m / 2; j < w - m / 2; j ++ )
            {
                for ( int k = i - n / 2; k <= i + n / 2; k ++ )
                {
                    for ( int l = j - m / 2; l <= j + m / 2; l ++ )
                    {
                        r_sum += image[k][l].r * mul[k - (i - n / 2)][l - (j - m / 2)];
                        g_sum += image[k][l].g * mul[k - (i - n / 2)][l - (j - m / 2)];
                        b_sum += image[k][l].b * mul[k - (i - n / 2)][l - (j - m / 2)];
                    }
                }

                image[i][j].r = int(r_sum);
                image[i][j].g = int(g_sum);
                image[i][j].b = int(b_sum);

                r_sum = 0;
                g_sum = 0;
                b_sum = 0;
            }
        }

        image_out << type << endl;
        image_out << w << " " << h << endl;
        image_out << maximum_color_value_of_the_image << endl;

        for ( int i = 0; i < h; i ++ )
        {
            for ( int j = 0; j < w; j ++ )
            {
                image_out << image[i][j].r << " " << image[i][j].g << " " << image[i][j].b << endl;
            }
        }
    }

    image_in.close();
    image_out.close();
}

void MakeTransition(int h, int w, int max_color_value, int mul, int add_differential, int max_transition_iteration, int goal_red, int goal_green, int goal_blue, ofstream& image_out)
{
    h *= mul;
    w *= mul;
    max_color_value *= mul;
    max_transition_iteration *= mul;
    goal_red *= mul;
    goal_green *= mul;
    goal_blue *= mul;

    image_out.open("transition.ppm");

    if ( image_out.is_open() )
    {
        image_out << "P3" << endl;

        image_out << w << " " << h - add_differential << endl;

        image_out << max_color_value + 2 * add_differential << endl;

        float add_red_color_value = goal_red / max_transition_iteration;
        float add_green_color_value = goal_green / max_transition_iteration;
        float add_blue_color_value = goal_blue / max_transition_iteration;

        float red_color_value = add_red_color_value * add_differential;
        float green_color_value = add_green_color_value * add_differential;
        float blue_color_value = add_blue_color_value * add_differential;

        int partition_unit = ( h - add_differential ) / max_transition_iteration;

        for ( int y = add_differential; y <= h; y ++ )
        {
            for ( int x = 1; x <= w; x ++ )
            {
                image_out << (int)red_color_value << " " << (int)green_color_value << " " << (int)blue_color_value << endl;
            }

            if ( y % partition_unit == 0 )
            {
                red_color_value += add_red_color_value;
                green_color_value += add_green_color_value;
                blue_color_value += add_blue_color_value;
            }
        }
    }

    image_out.close();
}
