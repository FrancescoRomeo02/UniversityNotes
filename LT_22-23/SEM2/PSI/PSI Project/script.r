# carco txt
# Carica il dataset in formato TXT con una riga di intestazione
dataset <- read.table("dataset.txt", header = TRUE)

# elimina colonne da 2 a 8
dataset <- dataset[, -c(1:9)]

# accorpa le colonne di vendita bici
somma_colonne <- colSums(dataset)

png("pie.png", width = 1000, height = 800)

# crea il grafico a torta con le percentuali e il nome
pie(somma_colonne, labels = paste0(names(somma_colonne), " ", round(somma_colonne / sum(somma_colonne) * 100, 1), "%"), main = "Vendite bici")

dev.off()
