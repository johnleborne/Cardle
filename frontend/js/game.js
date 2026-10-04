fetch("https://cardle-3.onrender.com/api/test")
    .then(response => response.text())
    .then(data => {
        console.log(data);
    });

const cardList = [];
const houseCardList = [];
const deckContainer = document.getElementById("deckContainer");

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
                            document.querySelectorAll(".card-button")
                                .forEach(btn => btn.classList.add("clicked"));
                            button.classList.remove("clicked");

                            console.log("Card clicked:", card);
                        });

                        deckContainer.appendChild(button);
                    });

                    // Display house cards
                    const houseDeckContainer = document.getElementById("houseDeckContainer");
                    houseDeckContainer.innerHTML = "";
                    houseCardList.forEach(card => {
                        const button = document.createElement("button");
                        button.classList.add("house-card-button");

                        button.textContent = card.name + " " + card.value;

                        button.addEventListener("click", () => {
                            document.querySelectorAll(".house-card-button")
                                .forEach(btn => btn.classList.add("clicked"));
                            button.classList.remove("clicked");

                            console.log("Card clicked:", card);
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