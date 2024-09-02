#include <iostream>
#include <vector>
#include <chrono>
#include <omp.h>

using namespace std;
using namespace std::chrono;

// Función para encontrar combinaciones de manera secuencial
void encontrarCombinacionesSecuencial(vector<int>& candidatos, int objetivo, vector<int>& combinacion, int indice) {
    if (objetivo == 0) {
        // Imprimir la combinación actual
        cout << "Combinación encontrada: ";
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

// Función para encontrar combinaciones de manera paralela
void encontrarCombinacionesParalelo(vector<int>& candidatos, int objetivo, vector<int> combinacion, int indice) {
    if (objetivo == 0) {
        // Imprimir la combinación actual
#pragma omp critical
        {
            // Región crítica para evitar condiciones de carrera al imprimir
            cout << "Combinación encontrada: ";
            for (int num : combinacion) {
                cout << num << " ";
            }
            cout << endl;
        }
        return;
    }

#pragma omp parallel // Inicia una región paralela
    {
#pragma omp single // Solo un hilo ejecuta el bloque siguiente
        {
            for (int i = indice; i < candidatos.size(); ++i) {
                if (candidatos[i] > objetivo) continue;

                vector<int> nueva_combinacion = combinacion;
                nueva_combinacion.push_back(candidatos[i]);

#pragma omp task // Crear una tarea para cada nueva recursión
                {
                    encontrarCombinacionesParalelo(candidatos, objetivo - candidatos[i], nueva_combinacion, i);
                }
            }
        }
    }
}

// Función para mostrar el menú
void mostrarMenu() {
    cout << "Seleccione el modo de ejecución:" << endl;
    cout << "1. Secuencial" << endl;
    cout << "2. Paralelo" << endl;
    cout << "0. Salir" << endl;
}

int main() {
    vector<int> candidatos = { 2, 3, 6, 7 };
    int objetivo;
    int opcion;

    cout << "Ingrese el valor objetivo: ";
    cin >> objetivo;

    do {
        mostrarMenu();  // Mostrar menú
        cin >> opcion;  // Leer opción

        vector<int> combinacion;  // Vector para almacenar la combinación

        switch (opcion) {
        case 1: {
            // Medir tiempo de ejecución secuencial
            auto inicio_secuencial = high_resolution_clock::now();
            encontrarCombinacionesSecuencial(candidatos, objetivo, combinacion, 0);
            auto fin_secuencial = high_resolution_clock::now();
            auto duracion_secuencial = duration_cast<milliseconds>(fin_secuencial - inicio_secuencial);
            cout << "Tiempo de ejecución secuencial: " << duracion_secuencial.count() << " ms" << endl;
            break;
        }
        case 2: {
            // Medir tiempo de ejecución paralelo
            auto inicio_paralelo = high_resolution_clock::now();
            encontrarCombinacionesParalelo(candidatos, objetivo, combinacion, 0);
            auto fin_paralelo = high_resolution_clock::now();
            auto duracion_paralelo = duration_cast<milliseconds>(fin_paralelo - inicio_paralelo);
            cout << "Tiempo de ejecución paralelo: " << duracion_paralelo.count() << " ms" << endl;
            break;
        }
        case 0:
            cout << "Saliendo..." << endl;
            break;
        default:
            cout << "Opción no válida. Intente de nuevo." << endl;
        }
    } while (opcion != 0);

    return 0;
}
