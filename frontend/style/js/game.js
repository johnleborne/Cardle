fetch("http://localhost:8080/api/test")
    .then(response => response.text())
    .then(data => {
        console.log(data);
    });

    document.getElementById("starterDeck").addEventListener("click", () => {
        fetch("http://localhost:8080/api/card")
            .then(response => response.json())
            .then(card => {
                console.log("Starter Deck Card:", card);
            })
            .catch(error => {
                console.error("Error:", error);
            });
    });