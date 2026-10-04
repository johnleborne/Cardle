fetch("http://localhost:8080/api/test")
    .then(response => response.text())
    .then(data => {
        console.log(data);
    });

fetch("http://localhost:8080/api/card")
    .then(response => response.json())
    .then(card => {

        console.log(card);

        console.log(card.suit);
        console.log(card.name);
        console.log(card.value);
        console.log(card.rarity);

    })
    .catch(error => {
        console.error("Error:", error);
    });