fetch("http://localhost:8080/api/test")
    .then(response => response.text())
    .then(data => {
        console.log(data);
    });

const cardList = [];
const deckContainer = document.getElementById("deckContainer");

document.getElementById("starterDeck").addEventListener("click", () => {

    cardList.length = 0;
    deckContainer.innerHTML = "";

    for (let i = 0; i < 5; i++) {

        fetch("http://localhost:8080/api/card")
            .then(response => response.json())
            .then(card => {

                cardList.push(card);

                console.log("Card received:", card);

                // Wait until all 5 cards have been received
                if (cardList.length === 5) {
                    const button = document.createElement("button");
                    button.textContent = "TEST BUTTON";
                    deckContainer.appendChild(button);

                    console.log("Starter Deck:", cardList);

                    cardList.forEach(card => {

                        const button = document.createElement("button");

                        button.textContent =
                            card.name + " " + card.value;

                        button.addEventListener("click", () => {
                            console.log("Card clicked:", card);
                        });

                        deckContainer.appendChild(button);
                    });
                }
            })
            .catch(error => {
                console.error("Error:", error);
            });
    }
});