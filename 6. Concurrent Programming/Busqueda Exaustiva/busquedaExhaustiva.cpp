#include <iostream>
#include <vector>
#include <chrono>
#include <omp.h>

using namespace std;
using namespace std::chrono;

// Funcion para encontrar combinaciones de manera secuencial
void encontrarCombinacionesSecuencial(vector<int>& candidatos, int objetivo, vector<int>& combinacion, int indice) {
    if (objetivo == 0) {
        // Imprimir la combinacion actual
        cout << "Combinacion encontrada: ";
        for (int num : combinacion) {
            cout << num << " ";
        }
        cout << endl;
        return;
    }

    for (int i = indice; i < candidatos.size(); ++i) {
        if (candidatos[i] > objetivo) continue;

        combinacion.push_back(candidatos[i]);
        encontrarCombinacionesSecuencial(candidatos, objetivo - candidatos[i], combinacion, i);
        combinacion.pop_back();
    }
}

// Funcion para encontrar combinaciones de manera paralela
void encontrarCombinacionesParalelo(vector<int>& candidatos, int objetivo, vector<int> combinacion, int indice) {
    if (objetivo == 0) {
        // Imprimir la combinacion actual
        #pragma omp critical
        { 
            // Region critica para evitar condiciones de carrera al imprimir
            cout << "Combinacion encontrada: ";
            for (int num : combinacion) {
                cout << num << " ";
            }
            cout << endl;
        }
        return;
    }

    #pragma omp parallel // Inicia una region paralela
    {
        #pragma omp single // Solo un hilo ejecuta el bloque siguiente
        {
            for (int i = indice; i < candidatos.size(); ++i) {
                if (candidatos[i] > objetivo) continue;

                vector<int> nueva_combinacion = combinacion;
                nueva_combinacion.push_back(candidatos[i]);

                #pragma omp task // Crear una tarea para cada nueva recursion
                {
                    encontrarCombinacionesParalelo(candidatos, objetivo - candidatos[i], nueva_combinacion, i);
                }
            }
        }
    }
}

int main() {
    vector<int> candidatos = {2, 3, 6, 7};
    int objetivo;
    
    cout << "Ingrese el valor objetivo: ";
    cin >> objetivo;

    vector<int> combinacion;

    // Medir tiempo de ejecucion secuencial
    auto inicio_secuencial = high_resolution_clock::now();
    encontrarCombinacionesSecuencial(candidatos, objetivo, combinacion, 0);
    auto fin_secuencial = high_resolution_clock::now();
    auto duracion_secuencial = duration_cast<milliseconds>(fin_secuencial - inicio_secuencial);

    cout << "Tiempo de ejecucion secuencial: " << duracion_secuencial.count() << " ms" << endl;

    // Medir tiempo de ejecucion paralelo
    auto inicio_paralelo = high_resolution_clock::now();
    encontrarCombinacionesParalelo(candidatos, objetivo, combinacion, 0);
    auto fin_paralelo = high_resolution_clock::now();
    auto duracion_paralelo = duration_cast<milliseconds>(fin_paralelo - inicio_paralelo);

    cout << "Tiempo de ejecucion paralelo: " << duracion_paralelo.count() << " ms" << endl;

    return 0;
}

