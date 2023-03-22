#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <chrono>

using namespace std;

int main() {
    for (int k = 0; k < 20; k++) {
        auto start_time = chrono::high_resolution_clock::now();
        // Aquí va el fragmento de código a repetir

        ifstream inputFile("2x2.txt");
        string linea;
        string matriz;
        getline(inputFile, linea);
        istringstream iss(linea);
        int alto, ancho;
        iss >> alto >> ancho;

        vector<vector<int>> matriz;
        int i=0;
        while (getline(inputFile, linea)) {
            istringstream iss(linea);
            vector<int> fila;
            int numero;


            while (iss >> numero) {
                fila.push_back(numero);
            }
            if (fila.empty()) {
                continue;
            }
            for (int j = 0; j < fila.size(); j++) {
                if (matriz.size() == 0 || matriz.size() % 2 == 0) {
                    fila[j] += 1;
                }
                if (j == 0 || j % 2 == 0) {
                    fila[j] += 2;
                }
                if (matriz.size() % 2 != 0 && j % 2 != 0) {
                    fila[j] -= 3;
                }
            }
            matriz.push_back(fila);
            i++;

        }

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (j == ancho - 1) {
                    matriz += matriz[i][j] << endl;
                } else {
                    matriz += matriz[i][j] << " ";
                }
            }

        }

        /*cout << "Matriz resultante:" << endl;
        for (int i = 0; i < matriz.size(); i++) {
            for (int j = 0; j < matriz[i].size(); j++) {
                matriz += matriz[i][j] << " ";
            }
            matriz += endl;
        }*/


        inputFile.close();

        auto end_time = chrono::high_resolution_clock::now();
        double execution_time = chrono::duration_cast<chrono::nanoseconds>(end_time - start_time).count();
        cout << execution_time + "\n";
    }
    return 0;
}