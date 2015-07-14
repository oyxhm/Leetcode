"""
# generate ListNode from unpacking list
>>> l = l = ListNode(*range(10))

>>> l
<ListNode [0]>

>>> print l
<ListNode [0]>: 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9

# build from list, for situations when length is greater than 255
>>> l2 = ListNode.build_from_list(range(256))
>>> print l2
<ListNode [0]>: 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16 -> 17 -> 18 -> 19 -> 20 -> 21 -> 22 -> 23 -> 24 -> 25 -> 26 -> 27 -> 28 -> 29 -> 30 -> 31 -> 32 -> 33 -> 34 -> 35 -> 36 -> 37 -> 38 -> 39 -> 40 -> 41 -> 42 -> 43 -> 44 -> 45 -> 46 -> 47 -> 48 -> 49 -> 50 -> 51 -> 52 -> 53 -> 54 -> 55 -> 56 -> 57 -> 58 -> 59 -> 60 -> 61 -> 62 -> 63 -> 64 -> 65 -> 66 -> 67 -> 68 -> 69 -> 70 -> 71 -> 72 -> 73 -> 74 -> 75 -> 76 -> 77 -> 78 -> 79 -> 80 -> 81 -> 82 -> 83 -> 84 -> 85 -> 86 -> 87 -> 88 -> 89 -> 90 -> 91 -> 92 -> 93 -> 94 -> 95 -> 96 -> 97 -> 98 -> 99 -> 100 -> 101 -> 102 -> 103 -> 104 -> 105 -> 106 -> 107 -> 108 -> 109 -> 110 -> 111 -> 112 -> 113 -> 114 -> 115 -> 116 -> 117 -> 118 -> 119 -> 120 -> 121 -> 122 -> 123 -> 124 -> 125 -> 126 -> 127 -> 128 -> 129 -> 130 -> 131 -> 132 -> 133 -> 134 -> 135 -> 136 -> 137 -> 138 -> 139 -> 140 -> 141 -> 142 -> 143 -> 144 -> 145 -> 146 -> 147 -> 148 -> 149 -> 150 -> 151 -> 152 -> 153 -> 154 -> 155 -> 156 -> 157 -> 158 -> 159 -> 160 -> 161 -> 162 -> 163 -> 164 -> 165 -> 166 -> 167 -> 168 -> 169 -> 170 -> 171 -> 172 -> 173 -> 174 -> 175 -> 176 -> 177 -> 178 -> 179 -> 180 -> 181 -> 182 -> 183 -> 184 -> 185 -> 186 -> 187 -> 188 -> 189 -> 190 -> 191 -> 192 -> 193 -> 194 -> 195 -> 196 -> 197 -> 198 -> 199 -> 200 -> 201 -> 202 -> 203 -> 204 -> 205 -> 206 -> 207 -> 208 -> 209 -> 210 -> 211 -> 212 -> 213 -> 214 -> 215 -> 216 -> 217 -> 218 -> 219 -> 220 -> 221 -> 222 -> 223 -> 224 -> 225 -> 226 -> 227 -> 228 -> 229 -> 230 -> 231 -> 232 -> 233 -> 234 -> 235 -> 236 -> 237 -> 238 -> 239 -> 240 -> 241 -> 242 -> 243 -> 244 -> 245 -> 246 -> 247 -> 248 -> 249 -> 250 -> 251 -> 252 -> 253 -> 254 -> 255

# iterate through list
>>> vals = list()
>>> for node in l:
...     vals.append(node.val)
>>> print vals
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

# get ListNode by index
>>> l[3]
<ListNode [3]>
>>> l[-3]
<ListNode [7]>
>>> l[100]
Traceback (most recent call last):
...
IndexError: ListNode index out of range
>>> l[-11]
Traceback (most recent call last):
...
IndexError: ListNode index out of range

# compare
>>> print l[4] > l[2], l[5] >= l[5], l[3] < l[5], l[6] <= l[6]
True True True True

# __contains__
>>> print 9 in l
True

# reverse
>>> print ListNode.reverse(l)
<ListNode [9]>: 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 0
"""
import doctest


class ListNode:
    def __init__(self, *xs):
        if not xs:
            raise ValueError("not enough elements")
        self.val = xs[0]
        self.next = None
        p = self
        for x in xs[1:]:
            node = ListNode(x)
            p.next = node
            p = node

    @staticmethod
    def build_from_list(xs):
        if not xs:
            raise ValueError("not enough elements")
        head = ListNode(xs[0])
        p = head
        for x in xs[1:]:
            node = ListNode(x)
            p.next = node
            p = node
        return head

    @staticmethod
    def reverse(head):
        if not head or not head.next:
            return head
        new_head = ListNode.reverse(head.next)
        head.next.next = head
        head.next = None
        return new_head

    def __lt__(self, other):
        if not isinstance(other, ListNode):
            raise TypeError('Comparing type should be instance of ListNode')
        return self.val < other.val

    def __le__(self, other):
        if not isinstance(other, ListNode):
            raise TypeError('Comparing type should be instance of ListNode')
        return self.val <= other.val

    def __gt__(self, other):
        if not isinstance(other, ListNode):
            raise TypeError('Comparing type should be instance of ListNode')
        return self.val > other.val

    def __ge__(self, other):
        if not isinstance(other, ListNode):
            raise TypeError('Comparing type should be instance of ListNode')
        return self.val >= other.val

    def __iter__(self):
        cur = self
        while cur:
            yield cur
            cur = cur.next

    def __getitem__(self, index):
        if index >= 0:
            i = 0
            cur = self
            while i < index:
                if not cur:
                    raise IndexError('ListNode index out of range')
                cur = cur.next
                i += 1
            return cur
        else:   # index < 0, get node from the end of list
            fast = slow = self
            while index < 0:
                if not fast:
                    raise IndexError('ListNode index out of range')
                fast = fast.next
                index += 1
            while fast:
                fast = fast.next
                slow = slow.next
            return slow

    def __contains__(self, x):
        for node in self:
            if node.val == x:
                return True
        return False

    def __str__(self):
        vals = []
        head = self
        while head:
            vals.append(head.val)
            head = head.next
        return self.__repr__() + ': ' + ' -> '.join(map(str, vals))

    def __repr__(self):
        return '<ListNode [%s]>' % self.val


if __name__ == '__main__':
    doctest.testmod()
