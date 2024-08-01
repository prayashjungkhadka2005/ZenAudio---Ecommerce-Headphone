document.querySelectorAll(".product-card").forEach((card) => {
  const increaseBtn = card.querySelector(".increase-btn");
  const decreaseBtn = card.querySelector(".decrease-btn");
  const quantityInput = card.querySelector(".quantity-input");

  increaseBtn.addEventListener("click", () => {
    const currentValue = parseInt(quantityInput.value);
    if (currentValue < parseInt(quantityInput.getAttribute("max"))) {
      quantityInput.value = currentValue + 1;
    }
  });

  decreaseBtn.addEventListener("click", () => {
    const currentValue = parseInt(quantityInput.value);
    if (currentValue > parseInt(quantityInput.getAttribute("min"))) {
      quantityInput.value = currentValue - 1;
    }
  });
});
// Galley where user insert img

document.addEventListener("DOMContentLoaded", function () {
  const gallery = document.getElementById("gallery");
  const imgDiv = document.querySelector(".img-div");
  const selectedImage = document.getElementById("selected-image");

  // Click event listener on the gallery image
  selectedImage.addEventListener("click", function () {
    const fileInput = document.createElement("input");
    fileInput.type = "file";
    fileInput.accept = "image/*";
    fileInput.style.display = "none";

    // Trigger click event on file input
    fileInput.addEventListener("change", function (e) {
      const file = e.target.files[0];
      if (file) {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function () {
          selectedImage.src = reader.result;
        };
      }
    });

    document.body.appendChild(fileInput);
    fileInput.click();
    document.body.removeChild(fileInput);
  });

  // Prevent default behavior for drag and drop events
  ["dragenter", "dragover", "dragleave", "drop"].forEach((eventName) => {
    gallery.addEventListener(eventName, preventDefaults, false);
    document.body.addEventListener(eventName, preventDefaults, false);
  });

  // Highlight drop area when dragging over
  ["dragenter", "dragover"].forEach((eventName) => {
    gallery.addEventListener(eventName, highlight, false);
  });

  // Remove highlight when dragging leaves the drop area
  ["dragleave", "drop"].forEach((eventName) => {
    gallery.addEventListener(eventName, unhighlight, false);
  });

  // Handle dropped files
  gallery.addEventListener("drop", handleDrop, false);

  function preventDefaults(e) {
    e.preventDefault();
    e.stopPropagation();
  }

  function highlight() {
    imgDiv.classList.add("highlight");
  }

  function unhighlight() {
    imgDiv.classList.remove("highlight");
  }

  function handleDrop(e) {
    const dt = e.dataTransfer;
    const files = dt.files;

    handleFiles(files);
  }

  function handleFiles(files) {
    for (let i = 0; i < files.length; i++) {
      const file = files[i];

      if (file.type.startsWith("image/")) {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function () {
          selectedImage.src = reader.result;
        };
      }
    }
  }
});
