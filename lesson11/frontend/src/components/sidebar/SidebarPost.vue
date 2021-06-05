<template>
    <section>
        <div class="header">
            {{ post.title }}
        </div>
        <div class="body">
            {{ post.text }}
        </div>
        <div class="footer">
            <a href="#" @click.prevent="changePageToPostId(post)">View all</a>
        </div>
    </section>
</template>

<script>
export default {
    name: "SidebarPost",
    props: ["post"],
    methods: {
        changePageToPostId: function (post) {
            this.$root.$emit("onChangePageToPost", post)
        }
    }
}
</script>

<style scoped>
section {
    margin-bottom: 1rem;
}
</style>