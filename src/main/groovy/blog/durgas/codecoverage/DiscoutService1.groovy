package blog.durgas.codecoverage

class DiscoutService1 {
    Double getDiscountPercentage(String memberType) {
        Double discountPercentage = null
        switch (memberType) {
            case 'gold':
                discountPercentage = 30
            case 'silver':
                discountPercentage = 20
        }
        return discountPercentage
    }
}
