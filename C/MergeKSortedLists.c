// https://leetcode.com/problems/merge-k-sorted-lists/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
void mergeKNodes(struct ListNode* node, struct ListNode** lists, int listsSize) {    
    bool allNull = true;
    
    for (int i=0; i<listsSize; i++) {
        if (lists[i] != NULL) {
            allNull = false;
            break;
        }
    }
    
    if (allNull) {
        return;
    }
    //find min value
    int index = 0;
    int min = INT_MAX;
    
    for (int i=0; i<listsSize; i++) {
        if((lists[i] != NULL) && (lists[i]->val <= min)) {
            index = i;
            min = lists[i]->val;
        }
    }
    //add it to list and advance
    node->next = lists[index];
    lists[index] = lists[index]->next;
        
    //call recursive method
    mergeKNodes(node->next, lists, listsSize);
}


struct ListNode* mergeKLists(struct ListNode** lists, int listsSize){
    struct ListNode* head = malloc(sizeof(struct ListNode));
    head->next = NULL;
    mergeKNodes(head, lists, listsSize);
    return head->next;
}