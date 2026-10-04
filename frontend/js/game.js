fetch("http://localhost:8080/api/test")
    .then(response => response.text())
    .then(data => {
        console.log(data);
    });

    const cardList = [];
    const deckContainer = document.getElementById("deckContainer");

    document.getElementById("starterDeck").addEventListener("click", () => {
        fetch("http://localhost:8080/api/card")
            .then(response => response.json())
            .then(card => {
                for(i = 0; i < 5; i++) {
                    card = getCard();
                    cardList.push(card);
                }
                console.log("Starter Deck:", cardList);
                buttonLabels.forEach(label => {
                    const button = document.createElement("button");
                    button.textContent = label;
                    button.addEventListener('click', () => {
                        console.log(`Button "${label}" was clicked!`);
                        handleButtonClick(label);
                    });
                    deckContainer.appendChild(button);
                });
                
            })
            .catch(error => {
                console.error("Error:", error);
            });
    });