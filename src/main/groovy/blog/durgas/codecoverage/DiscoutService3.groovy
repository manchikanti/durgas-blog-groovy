package blog.durgas.codecoverage

class DiscoutService3 {
    Double getDiscountPercentage(String memberType) {
        Double discountPercentage = null
        switch (memberType) {
            case 'bronze':
                discountPercentage = 10
            case 'gold':
                discountPercentage = 30
                break
            case 'silver':
                discountPercentage = 20
                break
        }
        return discountPercentage
    }
}
