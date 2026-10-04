fetch("https://cardle-3.onrender.com/api/test")
    .then(response => response.text())
    .then(data => {
        console.log(data);
    });

const cardList = [];
const houseCardList = [];
const deckContainer = document.getElementById("deckContainer");
const houseDeckContainer = document.getElementById("houseDeckContainer");

function areBothDecksSelected() {
    return deckContainer.querySelector(".card-button.clicked") !== null &&
        houseDeckContainer.querySelector(".house-card-button.clicked") !== null;
}

document.getElementById("starterDeck").addEventListener("click", () => {

    cardList.length = 0;
    deckContainer.innerHTML = "";

    for (let i = 0; i < 10; i++) {

        fetch("https://cardle-3.onrender.com/api/card")
            .then(response => response.json())
            .then(card => {

                if(i < 5)
                    cardList.push(card);
                else
                    houseCardList.push(card);

                console.log("Card received:", card);

                // Wait until all 5 cards have been received
                if (cardList.length === 5 && houseCardList.length === 5) {

                    console.log("Starter Deck:", cardList);

                    cardList.forEach(card => {

                        const button = document.createElement("button");
                        button.classList.add("card-button");

                        button.textContent =
                            card.name + " " + card.value;

                        button.addEventListener("click", () => {
                            deckContainer.querySelectorAll(".card-button")
                                .forEach(btn => btn.classList.remove("clicked"));
                            button.classList.add("clicked");

                            console.log("Card clicked:", card);
                            if (areBothDecksSelected()) {
                                const button = document.createElement("button");
                                button.textContent = "Swap Cards";
                                button.addEventListener("click", () => {
                                    const playerCard = deckContainer.querySelector(".card-button.clicked");
                                    const houseCard = houseDeckContainer.querySelector(".house-card-button.clicked");
                                    if (playerCard && houseCard) {
                                        swapCards(playerCard, houseCard);
                                    }
                                });
                                swapContainer.appendChild(button);
                            }
                        });

                        deckContainer.appendChild(button);
                    });

                    // Display house cards
                    houseDeckContainer.innerHTML = "";
                    houseCardList.forEach(card => {
                        const button = document.createElement("button");
                        button.classList.add("house-card-button");

                        button.textContent = card.name + " " + card.value;

                        button.addEventListener("click", () => {
                            houseDeckContainer.querySelectorAll(".house-card-button")
                                .forEach(btn => btn.classList.remove("clicked"));
                            button.classList.add("clicked");

                            console.log("Card clicked:", card);
                            if (areBothDecksSelected()) {
                                console.log("A card is selected from each deck.");
                            }
                        });

                        houseDeckContainer.appendChild(button);
                    });
                }
            })
            .catch(error => {
                console.error("Error:", error);
            });
    }
});

function swapCards(playerCard, houseCard) {
    const playerCardClone = playerCard.cloneNode(true);
    const houseCardClone = houseCard.cloneNode(true);
    playerCard.classList.remove("clicked");
    playerCardClone.classList.remove("clicked");
    playerCard.replaceWith(houseCardClone);
    const houseDeckContainer =
        document.getElementById("houseDeckContainer");

    houseDeckContainer.innerHTML = "";
}