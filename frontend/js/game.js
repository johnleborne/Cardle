fetch("http://localhost:8080/api/test")
    .then(response => response.text())
    .then(data => {
        console.log(data);
    });

    const cardList = [];
    document.getElementById("starterDeck").addEventListener("click", () => {
        fetch("http://localhost:8080/api/card")
            .then(response => response.json())
            .then(card => {
                for(i = 0; i < 5; i++) {
                    card = getCard();
                    cardList.push(card);
                }
                console.log("Starter Deck:", cardList);
                
            })
            .catch(error => {
                console.error("Error:", error);
            });
    });