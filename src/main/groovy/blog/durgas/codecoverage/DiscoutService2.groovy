package blog.durgas.codecoverage

class DiscoutService2 {
    Double getDiscountPercentage(String memberType) {
        Double discountPercentage = null
        switch (memberType) {
            case 'gold':
                discountPercentage = 30
                break
            case 'silver':
                discountPercentage = 20
        }
        return discountPercentage
    }
}
