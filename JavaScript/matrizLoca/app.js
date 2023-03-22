

const fs = require('fs');

for (let p = 0; p < 20; p++) {

    console.time('rendimiento');
    let info = fs.readFileSync('Matriz_100x100.txt', { encoding: 'utf-8' });
    info = info.split(/\r\n|\r|\n/);

    const n = 1;

    for (let i = 0; i < n; i++) {
        const dimension = info[0];
        const [a, b] = dimension.split(' ').map(Number);
        let matriz = [];
        for (let j = 0; j < a; j++) {
            const fila = info[1 + j]
            matriz.push(fila.split(' '));
        }
        for (let j = 0; j < a; j++) {
            for (let k = 0; k < b; k++) {
                if (j == 0 || j % 2 == 0) matriz[j][k]++;
                if (k == 0 || k % 2 == 0) matriz[j][k] += 2;
                if (j % 2 != 0 && k % 2 != 0) matriz[j][k] -= 3;
            }
        }
        for (let j = 0; j < a; j++) {
            //console.log(' ' + matriz[j].join(' '));
        }
    }
    console.timeEnd('rendimiento');
}

