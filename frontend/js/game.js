

const cardList = [];
const houseCardList = [];
const deckContainer = document.getElementById("deckContainer");
const houseDeckContainer = document.getElementById("houseDeckContainer");
const swapContainer = document.getElementById("swapContainer");

function areBothDecksSelected() {
    return deckContainer.querySelector(".card-button.clicked") !== null &&
        houseDeckContainer.querySelector(".house-card-button.clicked") !== null;
}

function updateSwapButton() {
    if (!areBothDecksSelected()) {
        swapContainer.innerHTML = "";
        return;
    }

    if (swapContainer.querySelector(".swap-button")) {
        return;
    }

    const button = document.createElement("button");
    button.classList.add("swap-button");
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

document.getElementById("starterDeck").addEventListener("click", () => {

    cardList.length = 0;
    deckContainer.innerHTML = "";
    swapContainer.innerHTML = "";

    for (let i = 0; i < 10; i++) {
        console.log("HE:LLLLLPPPPPPPPPPPP");

        fetch("http://localhost:8080/api/card")
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
                            updateSwapButton();
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
                            updateSwapButton();
                        });

                        houseDeckContainer.appendChild(button);
                    });

                    calculateHandScore(cardList);
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
    const swapContainer = document.getElementById("swapContainer");

    houseDeckContainer.innerHTML = "";
    updateScoreToBeat(calculateScoreToBeat());
    swapContainer.innerHTML = "";

}

function updateScoreToBeat(score) {
    const scoreToBeatContainer = document.getElementById("scoreToBeat");
    scoreToBeatContainer.textContent = "Score to Beat: " + score;
}

function calculateHandScore(cardList){
    sum = 0;
    cardList.forEach(card => {
        let sum = card.value + sum;
    });

    console.log("Hand Score:", sum);
}
