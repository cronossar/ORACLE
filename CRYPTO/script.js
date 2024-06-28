document.getElementById('encryptBtn').addEventListener('click', function() {
    const inputText = document.getElementById('inputText').value;
    const encryptedText = btoa(inputText); // Encriptación básica usando Base64
    document.getElementById('outputText').value = encryptedText;
});

document.getElementById('decryptBtn').addEventListener('click', function() {
    const encryptedText = document.getElementById('outputText').value;
    try {
        const decryptedText = atob(encryptedText); // Desencriptación básica usando Base64
        document.getElementById('inputText').value = decryptedText;
    } catch (e) {
        alert('Texto encriptado inválido');
    }
});